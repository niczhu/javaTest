package com.jd.jdd.jrs.mp.repository;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jd.jdd.jrs.mp.BaseTest;
import com.jd.jdd.jrs.mp.dal.bean.MpAccountBean;
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
//        mpAccount.setPin("zhp3");
        mpAccount.setName("zhp3");
        mpAccount.setMobile("123456");
        mpAccount.setAge(10);

        List<MpAccountBean> list = mpAccountRepository.list();
        System.out.println(JSON.toJSONString(list));

        QueryWrapper<MpAccountBean> wrapper = new QueryWrapper<MpAccountBean>().eq("pin", "zhp");

        MpAccountBean one = mpAccountRepository.getOne(new QueryWrapper<MpAccountBean>().eq("pin", "zhp"));
        System.out.println(JSON.toJSONString(one));

//        boolean b = mpAccountRepository.saveOrUpdate(mpAccount);
//        System.out.println(b);
    }


    @Test
    public void testList() {
//        List<MpAccountBean> list = mpAccountRepository();
//        System.out.println(list);
        MpAccountBean bean = new MpAccountBean();
        bean.setPin("testpin");
    }


}
