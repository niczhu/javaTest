package com.jd.jdd.jrs.mp.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jd.jdd.jrs.mp.base.Repository.AbstractRepository;
import com.jd.jdd.jrs.mp.dal.bean.MpAccountBean;
import com.jd.jdd.jrs.mp.dal.mapper.MpAccountMapper;
import com.jd.jdd.jrs.mp.dal.model.MpAccountModel;
import com.jd.jdd.jrs.mp.repository.MpAccountRepository;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public MpAccountModel getEntityById(String id) {
        // TODO: 参数合法性检验

        MpAccountBean bean = getById(id);
        MpAccountModel model = objConvert(MpAccountModel.class, bean);
        return model;
    }

    @Override
    public List<MpAccountModel> search(MpAccountModel accountModel) {
        // TODO: 参数合法性检验

        MpAccountBean bean = this.objConvert(MpAccountBean.class, accountModel);
        QueryWrapper<MpAccountBean> wrapper = whereCondition(bean);

        List<MpAccountBean> beanList = mpAccountMapper.selectList(wrapper);

        List<MpAccountModel> modelList = convertToModels(beanList);

        return modelList;
    }

    @Override
    public MpAccountModel saveUpdateEntity(MpAccountModel accountModel) {
        // TODO: 参数合法性检验

        //TODO 初始化属性值
        MpAccountBean bean = this.objConvert(MpAccountBean.class, accountModel);
        boolean b = saveOrUpdate(bean);
        System.out.println("save or update db success=" + b);
        return accountModel;
    }

    @Override
    public boolean SaveUpdateBatchEntity(List<MpAccountModel> accountModels) {
        // TODO: 参数合法性检验

        //TODO 初始化属性值

        List<MpAccountBean> beanList = convertToBeans(accountModels);
        boolean b1 = saveOrUpdateBatch(beanList);
        return true;
    }

    @Override
    protected QueryWrapper<MpAccountBean> whereCondition(MpAccountBean bean) {
        QueryWrapper<MpAccountBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(StringUtils.isNotBlank(bean.getId()), MpAccountBean::getId, bean.getId());

        // TODO: 查询条件填充

        queryWrapper.last("limit 10000");
        System.out.println("条件查询一次最大查询1万条");
        return queryWrapper;
    }

    private List<MpAccountModel> convertToModels(List<MpAccountBean> beans) {
        if (null != beans && !beans.isEmpty()) {
            List<MpAccountModel> modelList = new ArrayList<>();
            for (MpAccountBean bean : beans) {
                MpAccountModel model = this.objConvert(MpAccountModel.class,bean);
                modelList.add(model);
            }
            return modelList;
        }
        return Collections.emptyList();
    }

    private List<MpAccountBean> convertToBeans(List<MpAccountModel> models) {
        if (CollectionUtils.isNotEmpty(models)) {
            List<MpAccountBean> beanList = new ArrayList<>();
            for (MpAccountModel model: models) {
                beanList.add(this.objConvert(MpAccountBean.class,model));
            }
            return beanList;
        }
        return Collections.emptyList();
    }


//    private MpAccountBean convertToBean(MpAccountModel model) {
//        MpAccountBean bean = new MpAccountBean();
//        if (null != model && StringUtils.isNotEmpty(model.getId())) {
//            try {
//                PropertyUtils.copyProperties(bean, model);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return bean;
//    }
//
//    private MpAccountModel convertToModel(MpAccountBean bean) {
//        MpAccountModel model = new MpAccountModel();
//        if (null != bean && StringUtils.isNotEmpty(bean.getId())) {
//            try {
//                PropertyUtils.copyProperties(model, bean);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return model;
//    }
//
}
