package com.jd.jdd.jrs.mp.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jd.jdd.jrs.mp.dal.bean.MpAccountBean;
import com.jd.jdd.jrs.mp.dal.mapper.MpAccountMapper;
import com.jd.jdd.jrs.mp.repository.MpAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * MpAccountRepositoryImpl
 *
 * @author zhuhaipeng6 in 2020/5/11 14:43
 * @version 1.0
 **/
@Repository
public class MpAccountRepositoryImpl extends BaseRepository implements MpAccountRepository {

    private ServiceImpl<MpAccountMapper,MpAccountBean> serviceImpl = new ServiceImpl<>();

    public void testList(){

    }
}
