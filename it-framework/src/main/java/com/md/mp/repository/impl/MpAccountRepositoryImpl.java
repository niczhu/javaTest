package com.md.mp.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.md.mp.base.Repository.AbstractRepository;
import com.md.mp.dal.bean.MpAccountBean;
import com.md.mp.dal.mapper.MpAccountMapper;
import com.md.mp.dal.model.MpAccountModel;
import com.md.mp.repository.MpAccountRepository;
import com.md.mp.utils.ConverterUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * MpAccountRepositoryImpl
 *
 * @author zhuhaipeng6 in 2020/5/11 14:43
 **/
@Repository
public class MpAccountRepositoryImpl extends AbstractRepository<MpAccountMapper, MpAccountBean, MpAccountModel> implements MpAccountRepository {

    @Autowired
    private MpAccountMapper mpAccountMapper;

    @Override
    public MpAccountModel getVoById(String id) {
        // TODO: 参数合法性检验
        MpAccountBean bean = getById(id);
        return ConverterUtil.objConvert(MpAccountModel.class, bean);
    }

    @Override
    public Page page(MpAccountModel model) {
        QueryWrapper<MpAccountBean> wrapper = baseWhereCondition(model);
        Page<MpAccountBean> queryPage = new Page<>(model.getCurrentPage(), model.getPageSize());
        Page<MpAccountBean> beanPage = mpAccountMapper.selectPage(queryPage, wrapper);

        Page<MpAccountModel> modelPage = new Page<>(model.getCurrentPage(), model.getPageSize());
        return modelPage.setRecords(ConverterUtil.objConvertList(MpAccountModel.class, beanPage.getRecords()));
    }

    @Override
    public List<MpAccountModel> search(MpAccountModel accountModel) {
        // TODO: 参数合法性检验
        QueryWrapper<MpAccountBean> wrapper = whereCondition(accountModel);
        List<MpAccountBean> beanList = mpAccountMapper.selectList(wrapper);

        return ConverterUtil.objConvertList(MpAccountModel.class, beanList);
    }

    @Override
    public MpAccountModel saveUpdateVo(MpAccountModel accountModel) {
        // TODO: 参数合法性检验
        //TODO 初始化属性值
        MpAccountBean bean = ConverterUtil.objConvert(MpAccountBean.class, accountModel);
        boolean b = saveOrUpdate(bean);
        if (b) {
            return accountModel;
        }
        System.out.println("save exp");
        return null;
    }

    @Override
    public boolean SaveUpdateBatchVo(List<MpAccountModel> accountModels) {
        // TODO: 参数合法性检验
        //TODO 初始化属性值
        return saveOrUpdateBatch(ConverterUtil.objConvertList(MpAccountBean.class, accountModels));
    }

    @Override
    public List<MpAccountModel> search(Map<String, Object> queryParams) {
        return null;
    }

    @Override
    protected QueryWrapper<MpAccountBean> whereCondition(MpAccountModel model) {
        QueryWrapper<MpAccountBean> queryWrapper = baseWhereCondition(model);

        // TODO: 查询条件填充
//        queryWrapper.orderBy()

        // 置后
        if (model.getPageSize() == 0) {
            queryWrapper.last("limit 0,10000");
        } else {
            String limit = StringUtils.join("limit ", String.valueOf((int) model.getCurrentPage()), String.valueOf((int) model.getPageSize()));
            queryWrapper.last(limit);
        }
        System.out.println("条件查询条数 , pageSize=" + model.getPageSize());
        return queryWrapper;
    }

    protected QueryWrapper<MpAccountBean> baseWhereCondition(MpAccountModel model) {
        QueryWrapper<MpAccountBean> queryWrapper = new QueryWrapper<>();

        // TODO: 基本查询条件填充
        queryWrapper.lambda()
                .eq(StringUtils.isNotEmpty(model.getId()), MpAccountBean::getId, model.getId())
                .eq(StringUtils.isNotEmpty(model.getPin()), MpAccountBean::getPin, model.getPin())
                .eq(StringUtils.isNotEmpty(model.getName()), MpAccountBean::getName, model.getName());

        return queryWrapper;
    }

//    private List<MpAccountModel> convertToModels(List<MpAccountBean> beans) {
//        if (CollectionUtils.isNotEmpty(beans)) {
//            List<MpAccountModel> modelList = new ArrayList<>();
//            for (MpAccountBean bean : beans) {
//                MpAccountModel model = this.objConvert(MpAccountModel.class, bean);
//                modelList.add(model);
//            }
//            return modelList;
//        }
//        return Collections.emptyList();
//    }
//
//    private List<MpAccountBean> convertToBeans(List<MpAccountModel> models) {
//        if (CollectionUtils.isNotEmpty(models)) {
//            List<MpAccountBean> beanList = new ArrayList<>();
//            for (MpAccountModel model : models) {
//                beanList.add(this.objConvert(MpAccountBean.class, model));
//            }
//            return beanList;
//        }
//        return Collections.emptyList();
//    }


}
