package com.test.multiDataSource;

import com.test.multiDataSource.bean.SeckillBean;
import com.test.multiDataSource.dao.SeckillDao;
import com.test.multiDataSource.service.SeckillService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        SeckillService seckill = (SeckillService) ctx.getBean("seckillService");
        seckill.search();
        seckill.queryById(1004);
    }
}
