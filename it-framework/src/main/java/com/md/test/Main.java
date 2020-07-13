package com.md.test;


import com.alibaba.fastjson.JSON;
import com.md.it.test.if_else.BaseProcessor;
import com.md.it.framework.model.TableFieldEnum;
import com.md.mp.base.model.QueryParams;
import com.md.mp.dal.bean.MpAccountBean;
import com.md.mp.dal.model.MpAccountModel;
import org.apache.commons.beanutils.PropertyUtils;

public class Main {

    public static void main(String[] args) throws Exception {

    }

    public static void testIfElse() {
        final String A = "a";
        final String B = "b";
        BaseProcessor baseProcessor = new BaseProcessor(A);
        baseProcessor.invoke();
    }

    /**
     * 类转换
     */
    public static class ObjectConverter<D, R> {

        private D desObj;
//        private R resourceObj;

        public ObjectConverter(Class<D> dClass, Class<R> rClass) throws Exception {
            desObj = dClass.newInstance();
//            resourceObj = rClass.newInstance();
        }

        public <D> D convert(Class<D> dClass,Object r) throws Exception {
            D des= dClass.newInstance();
            if (r != null) {
                PropertyUtils.copyProperties(des, r);
            }
            System.out.println("convert object = " + JSON.toJSONString(des));
            return (D) des;
        }
    }

}
