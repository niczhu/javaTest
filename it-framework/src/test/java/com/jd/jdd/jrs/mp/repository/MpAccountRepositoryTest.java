package com.jd.jdd.jrs.mp.repository;

import com.alibaba.fastjson.JSON;
import com.jd.jdd.jrs.mp.BaseTest;
import com.jd.jdd.jrs.mp.dal.bean.MpAccountBean;
import com.jd.jdd.jrs.mp.model.BaseModel;
import com.jd.jdd.jrs.mp.model.MpAccountModel;
import com.jd.jdd.jrs.mp.repository.impl.MpAccountRepositoryImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MpAccountRepositoryTest extends BaseTest {

    @Autowired
    private MpAccountRepository mpAccountRepository;

    @Autowired private MpAccountRepositoryImpl mpAccountRepository2;

    @Test
    public void testSave() {
        MpAccountBean mpAccount = new MpAccountBean();
        mpAccount.setPin("zhp2");
        mpAccount.setName("zhp2");
        mpAccount.setMobile("123456");
        mpAccount.setAge(10);

//        boolean b = mpAccountRepository.saveOrUpdate(mpAccount);
//        System.out.println(b);
    }


    @Test
    public void testList() {
//        List<MpAccountBean> list = mpAccountRepository();
//        System.out.println(list);
        MpAccountBean bean = new MpAccountBean();
        bean.setPin("testpin");
        BaseModel baseModel = mpAccountRepository2.convertToVo(bean);
        System.out.println(JSON.toJSONString(baseModel));
    }


}
