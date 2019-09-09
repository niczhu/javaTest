package com.test.redis;

import com.fasterxml.jackson.databind.util.JSONPObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.List;

public class JedisMulti {

    private static Jedis jedis = JedisClient.getJedis();

    public static void main(String[] args) {

        jedis.del("key");

        if(!jedis.exists("key")){
            jedis.set("key","30");
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " =>");

            new Thread(()->{

                watch("key","30");
                String key = jedis.get("key");
                System.out.println(" rst ="+key);

            }).start();

        }

    }

    public static void trx(String k,String v){

        for(;;) {

            try {
                Transaction t = jedis.multi();
                Response<String> setex = t.setex(k, 4, v);

                System.out.println(setex);

                List<Object> exec = t.exec();
                if (exec == null || exec.isEmpty()) {
                    System.out.println("事务执行失败");

                } else {
                    System.out.println("success==>exec");
                    break;
                }

            }finally {
                jedis.close();
            }

        }
    }

    public static void watch(String k,String v){

        for(;;) {
            try {
                jedis.watch(k);

                int count = Integer.parseInt(jedis.get(k));

                Transaction t = jedis.multi();

                t.set(k,String.valueOf(count-1));

                List<Object> exec = t.exec();

                if (exec == null || exec.isEmpty()) {
                    System.out.println("事务执行失败");

                } else {
                    System.out.println("success==>exec");
                    break;
                }

            }finally {
//                jedis.close();
            }
        }
    }
}
