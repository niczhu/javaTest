package com.test.multiDataSource.service;

import com.test.multiDataSource.bean.SeckillBean;
import com.test.multiDataSource.dao.SeckillDao;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class SeckillService
{
    @Autowired
    private SeckillDao seckillDao;

    public void search(){
        List<SeckillBean> seckillBeans = seckillDao.queryAll(0, 10);

        System.out.println(seckillBeans.size());
    }

    public void queryById(long id){
        SeckillBean seckillBean = seckillDao.queryById(id);
        if(seckillBean ==null){
            System.out.println("query db is null");
        }

        System.out.println(seckillBean.getName());

    }

    @Transactional
    public void txTest(){
        System.out.println("======tx test=====");
        seckillDao.updateMaster(1000,"0000");

        seckillDao.updateSlaver(1004,"0000");
    }
}
