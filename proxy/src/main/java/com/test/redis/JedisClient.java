package com.test.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisClient {

    private static JedisPool jedisPool;

    private static JedisPoolConfig jedisPoolConfig;


    static {
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(5);
//        jedisPoolConfig.setMaxWaitMillis(1000*10);
        jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1");
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    public static void closePool(){
        jedisPool.close();
    }
}
