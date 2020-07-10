package com.md.mp.repository;

import com.alibaba.fastjson.JSON;
import com.md.mp.BaseTest;
import com.md.mp.dal.bean.MpAccountBean;
import com.md.mp.dal.model.MpAccountModel;
import com.md.mp.utils.ConverterUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MpAccountRepositoryTest extends BaseTest {

    @Autowired
    private MpAccountRepository mpAccountRepository;


    @Test
    public void testGetById() {

        MpAccountModel voById = mpAccountRepository.getVoById("1");
        System.out.println(voById);
    }

    @Test
    public void batchSave(){
        MpAccountModel account1 = new MpAccountModel();
        account1.setPin("zhp10");
        account1.setName("zhp10");
        account1.setMobile("10000");
        account1.setAge(10);

        MpAccountModel account2 = new MpAccountModel();
        account2.setPin("zhp12");
        account2.setName("zhp12");
        account2.setMobile("12222");
        account2.setAge(10);

        List<MpAccountModel> modelList = new ArrayList<>();
        modelList.add(account1);
        modelList.add(account2);

        List<MpAccountBean> desList = ConverterUtil.objConvertList(MpAccountBean.class, modelList);
        System.out.println(JSON.toJSONString(desList));

        boolean b = mpAccountRepository.SaveUpdateBatchVo(modelList);
        System.out.println(b);

    }

    @Test
    public void testSearch() {
        MpAccountModel mpAccount = new MpAccountModel();
        mpAccount.setPin("zhp10");
        mpAccount.setName("zhp10");
        mpAccount.setAge(10);

        List<MpAccountModel> search = mpAccountRepository.search(mpAccount);
        System.out.println(JSON.toJSONString(search));

    }

}
