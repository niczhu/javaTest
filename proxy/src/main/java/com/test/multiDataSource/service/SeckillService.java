package com.test.multiDataSource.service;

import com.test.multiDataSource.bean.SeckillBean;
import com.test.multiDataSource.dao.SeckillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeckillService
{
    @Autowired
    private SeckillDao seckillDao;

    public void search(){
        List<SeckillBean> seckillBeans = seckillDao.queryAll(0, 10);

        System.out.println(seckillBeans.size());
    };
}
