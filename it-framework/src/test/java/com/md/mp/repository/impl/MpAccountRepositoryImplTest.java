package com.md.mp.repository.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.md.mp.BaseTest;
import com.md.mp.dal.model.MpAccountModel;
import com.md.mp.repository.MpAccountRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MpAccountRepositoryImplTest extends BaseTest {

    @Autowired
    private MpAccountRepository mpAccountRepository;

    @Test
    public void getEntityById() {
        String id = "1";
        MpAccountModel entityById = mpAccountRepository.getVoById(id);
        System.out.println(JSON.toJSONString(entityById));
    }

    @Test
    public void search() {
        MpAccountModel mpAccountModel = new MpAccountModel();
        mpAccountModel.setId("1");
        List<MpAccountModel> search1 = mpAccountRepository.search(mpAccountModel);
        System.out.println(JSON.toJSONString(search1));
    }

    @Test
    public void saveUpdateEntity() {

        MpAccountModel mpAccountModel = new MpAccountModel();

        mpAccountModel.setBirthDay(new Date());
        mpAccountModel.setMobile("15200998876");
        mpAccountModel.setPin("pin1");
        mpAccountModel.setStatus("1");
        mpAccountModel.setId("1");
        mpAccountModel.setName("");

        MpAccountModel mpAccountModel1 = mpAccountRepository.saveUpdateVo(mpAccountModel);
        System.out.println(JSON.toJSONString(mpAccountModel1));

    }

    @Test
    public void saveUpdateBatchEntity() {

        MpAccountModel mpAccountModel = new MpAccountModel();
        mpAccountModel.setName("1");
        mpAccountModel.setAge(112);
        mpAccountModel.setBirthDay(new Date());
        mpAccountModel.setMobile("15200998876");
        mpAccountModel.setPin("pin1");
        mpAccountModel.setStatus("1");
        mpAccountModel.setId("1");

        //
        MpAccountModel mpAccountModel2 = new MpAccountModel();
        mpAccountModel2.setName("3");
        mpAccountModel2.setAge(3);
        mpAccountModel2.setBirthDay(new Date());
        mpAccountModel2.setMobile("15200998876");
        mpAccountModel2.setPin("pin3");
        mpAccountModel2.setStatus("3");

        List<MpAccountModel> modelList = new ArrayList<>();
        modelList.add(mpAccountModel);
        modelList.add(mpAccountModel2);

        boolean b = mpAccountRepository.SaveUpdateBatchVo(modelList);
        System.out.println("batch result => " + b);
    }

    @Test
    public void page() {
        MpAccountModel mpAccountModel2 = new MpAccountModel();
        mpAccountModel2.setId("1");
        Page page = mpAccountRepository.page(mpAccountModel2);
        System.out.println(JSON.toJSONString(page));
    }
}
