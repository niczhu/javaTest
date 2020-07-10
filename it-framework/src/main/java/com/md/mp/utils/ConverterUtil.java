package com.md.mp.utils;

import org.apache.commons.beanutils.PropertyUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * ObjectUtil
 *
 * @author zhuhaipeng6 in 2020/7/1 21:28
 * @version 1.0
 **/
public class ConverterUtil {

    /**
     * TODO:可做成独立类，支持扩展
     *
     * @param descObject
     * @param resObject
     */
    public static void copyProperties(Object descObject, Object resObject) {
        try {
            PropertyUtils.copyProperties(descObject, resObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 数组转换
     *
     * @param dClass        目标类型
     * @param origClassList 原始数组
     * @param <D>
     * @return
     */
    public static <D> List<D> objConvertList(Class<D> dClass, List<?> origClassList) {
        List<D> desList = new ArrayList<D>();
        if (null != origClassList && !origClassList.isEmpty()) {
            for (Object origin : origClassList) {
                D d = objConvert(dClass, origin);
                desList.add(d);
            }
        }
        return desList;
    }

    /**
     * 类型转换
     *
     * @param dClass
     * @param origClass
     * @param <D>
     * @return
     */
    public static <D> D objConvert(Class<D> dClass, Object origClass) {
        D des = null;
        try {
            des = dClass.newInstance();
            if (origClass != null) {
                copyProperties(des, origClass);
            }
            return (D) des;
        } catch (InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
