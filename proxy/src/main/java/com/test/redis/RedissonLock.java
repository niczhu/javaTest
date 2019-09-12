package com.test.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonLock {



    public static void main(String[] args) {

        String s = "10.0.5.1";
        int i = s.hashCode();
        System.out.println(i);


    }

    public static  void redissonLock(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        final RedissonClient client = Redisson.create(config);
        RLock lock = client.getLock("lock777");

        Thread thread = new Thread(()->{
            try{
                lock.lock();
                RSet<Object> k1 = client.getSet("k1");
            }finally {
                lock.unlock();
            }


        });

    }



}
