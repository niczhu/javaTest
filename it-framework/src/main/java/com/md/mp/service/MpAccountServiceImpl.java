package com.md.mp.service;

import com.md.mp.dal.bean.MpAccountBean;
import com.md.mp.dal.model.MpAccountModel;
import com.md.mp.repository.MpAccountRepository;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MpAccountServiceImpl
 *
 * @author zhuhaipeng6 in 2020/6/21 11:54
 * @version 1.0
 **/
@Service
public class MpAccountServiceImpl {

    @Autowired
    MpAccountRepository mpAccountRepository;

    public MpAccountModel getById(String id) throws Exception {
        MpAccountBean bean = mpAccountRepository.getById(id);
        MpAccountModel mpAccountModel = new MpAccountModel();
        PropertyUtils.copyProperties(mpAccountModel,bean);
       return mpAccountModel;
    }

}
