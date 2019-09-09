package com.test.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

/**
 * 指定过期时间内key的操作次数超过阈值 进行拦截
 *
 * 点赞防刷
 *
 */

public class JedisTimeCount {

    private static int count ;

    private static long timeOut = 500;

    private static String key = "k1";

    public static void main(String[] args) throws Exception{

        // init
        Jedis jedis = JedisClient.getJedis();

        jedis.setex(key,5,"0");

        for (int i = 0; i < 10; i++) {
            System.out.println("i =>"+i);

            String s = jedis.get(key);

            int c = Integer.parseInt(s);

            if(c < 5){
                c++;
                jedis.set(key,String.valueOf(c));
                System.out.println("count=>"+c);
            }else{
                System.out.println("count over");
            }

            Thread.sleep(1000);
        }


    }

}
