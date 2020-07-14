package com.md.test;


import com.alibaba.fastjson.JSON;
import com.md.it.framework.constraint.service.ValidatorServiceImpl;
import com.md.it.test.if_else.BaseProcessor;
import com.md.it.framework.model.TableFieldEnum;
import com.md.mp.base.model.QueryParams;
import com.md.mp.dal.bean.MpAccountBean;
import com.md.mp.dal.model.MpAccountModel;
import org.apache.commons.beanutils.PropertyUtils;

public class Main {

    public static void main(String[] args) throws Exception {
        testIfElse();
    }

    public static void testIfElse() {
        final String A = "a";
        final String B = "b";
        BaseProcessor baseProcessor = new BaseProcessor(A);
        baseProcessor.invoke();
    }

}
