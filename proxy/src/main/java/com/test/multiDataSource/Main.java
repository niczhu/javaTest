package com.test.multiDataSource;

import com.test.multiDataSource.bean.SeckillBean;
import com.test.multiDataSource.dao.SeckillDao;
import com.test.multiDataSource.service.SeckillService;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.jta.UserTransactionAdapter;
import redis.clients.jedis.Transaction;

import javax.sql.DataSource;
import javax.sql.XAConnection;
import java.sql.Connection;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        jtaTx();
    }

    public static void test(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        SeckillService seckill = (SeckillService) ctx.getBean("seckillService");
        seckill.search();
        seckill.queryById(1004);
    }

    public static void jtaTx(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SeckillService seckill = (SeckillService) ctx.getBean("seckillService");
        seckill.txTest();
    }
}
