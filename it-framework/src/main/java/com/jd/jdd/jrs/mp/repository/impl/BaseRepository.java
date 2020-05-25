package com.jd.jdd.jrs.mp.repository.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jd.jdd.jrs.mp.dal.bean.BaseBean;
import com.jd.jdd.jrs.mp.model.BaseModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseRepository
 *
 * @author zhuhaipeng6 in 2020/5/11 15:35
 * @version 1.0
 **/
@Slf4j
public class BaseRepository<B extends BaseBean, M extends BaseModel> {

    /**
     * bean convert to vo
     */
    public M convertToVo(B b) {
        M vo = null;
        if (b == null) {
            return null;
        }
        try {
            PropertyUtils.copyProperties(vo, b);
        } catch (Exception e) {
//            log.error("model转化为vo异常【{}】", b);
        }
        return vo;
    }

    <M> M newInstanceClass(Class<M> clazz) throws InstantiationException, IllegalAccessException {
        M obj = clazz.newInstance();
        return obj;
    }

    /**
     * bean convert to vo list
     *
     * @param dicList
     * @return
     */
//    public List<DictionaryVo> convertToVo(List<Dictionary> dicList) {
//        List<DictionaryVo> voList = new ArrayList<>();
//        for (Dictionary dictionary : dicList) {
//            voList.add(convertToVo(dictionary));
//        }
//        return voList;
//    }

    /**
     * vo convert to java bean
     *
     * @param vo
     * @return
     */
//    public Dictionary convertToBean(DictionaryVo vo) {
//        Dictionary dictionary = new Dictionary();
//        try {
//            PropertyUtils.copyProperties(dictionary, vo);
//        } catch (Exception e) {
//            log.error("vo转化为java bean 异常【{}】", e.getMessage());
//        }
//        return dictionary;
//    }

}
