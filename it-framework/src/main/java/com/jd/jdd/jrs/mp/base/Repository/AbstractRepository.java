package com.jd.jdd.jrs.mp.base.Repository;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jd.jdd.jrs.mp.base.mapper.SuperMapper;
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
public abstract class AbstractRepository<M extends SuperMapper<T>, T, V> extends ServiceImpl<M, T> implements BaseRepository<T, V> {

    protected abstract QueryWrapper<T> whereCondition(T bean);

    /**
     * 可做成独立类，支持扩展
     *
     * @param descObject
     * @param resObject
     */
    public void copyProperties(Object descObject, Object resObject) {
        try {
            PropertyUtils.copyProperties(descObject, resObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected <D> List<?> objConvertList(Class<D> dClass, List<?> origClassList) {
        List<D> desList = new ArrayList<D>();
        if (null != origClassList && !origClassList.isEmpty()) {
            for (Object origin : origClassList) {
                D d = objConvert(dClass, origin);
                desList.add(d);
            }
        }
        return desList;
    }

    protected <D> D objConvert(Class<D> dClass, Object origClass) {
        D des = null;
        try {
            des = dClass.newInstance();
            if (origClass != null) {
                copyProperties(des, origClass);
            }
            System.out.println("convert object = " + JSON.toJSONString(des));
            return (D) des;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
