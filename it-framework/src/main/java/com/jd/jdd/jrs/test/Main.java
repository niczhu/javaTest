package com.jd.jdd.jrs.test;


import com.alibaba.fastjson.JSON;
import com.jd.jdd.jrs.it.test.if_else.BaseProcessor;
import com.jd.jdd.jrs.it.framework.model.TableFieldEnum;
import com.jd.jdd.jrs.mp.dal.bean.MpAccountBean;
import com.jd.jdd.jrs.mp.dal.model.MpAccountModel;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws Exception {
        TestBean testBean = new TestBean();
        testBean.setName("nick");
        testBean.setAge(10);
        System.out.println(testBean);
        System.out.println(testBean.toString());

        System.out.println(TestBeanEnum.ADMIN.getClass());
        System.out.println(TestBeanEnum.ADMIN.getClass().isAssignableFrom(TableFieldEnum.class));
        System.out.println(TestBeanEnum.ADMIN instanceof TableFieldEnum);

        ObjectConverter<MpAccountBean, MpAccountModel> converter1 =
                new ObjectConverter<MpAccountBean, MpAccountModel>(MpAccountBean.class, MpAccountModel.class);
        MpAccountModel model1 = new MpAccountModel();
        model1.setName("nic");
        model1.setPin("pin");
        Object convert = converter1.convert(MpAccountBean.class,model1);

        System.out.println(JSON.toJSONString(convert));


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
