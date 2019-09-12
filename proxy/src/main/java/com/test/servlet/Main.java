package com.test.servlet;

import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TestServlet testServlet = new TestServlet();

        Map<String,String> map = new HashMap<>();
        map.put("1","aaa");
        map.put("2","bb");
        map.put("3","cca");

        map.forEach((k,v)->{
            System.out.println(k + "==>"+v);
        });

    }
}


