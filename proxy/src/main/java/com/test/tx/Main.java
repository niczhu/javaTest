package com.test.tx;

import com.mysql.jdbc.JDBC4Connection;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zhuhp
 * @Date 2019/9/15
 */
public class Main {
    public static void main(String[] args) {

//        Connection connection = new Connection();
//        JDBC4Connection jdbc4Connection = new JDBC4Connection();
        ConcurrentHashMap<Object, Object> a = new ConcurrentHashMap<>();
        a.put("1","bbb");
        a.put("10","2222");
        a.put("01","3333b");
    }
}
