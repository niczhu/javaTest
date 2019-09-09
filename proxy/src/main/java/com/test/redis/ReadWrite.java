package com.test.redis;

import redis.clients.jedis.Jedis;

public class ReadWrite
{

    public static void main(String[] args) {
        Jedis readJedis = new Jedis("127.0.0.1",6380);
        Jedis writeJedis = new Jedis("127.0.0.1",6379);

        String info = readJedis.info("replication");

        System.out.println(info);
        System.out.println("=======================");
        System.out.println(writeJedis.info("replication"));

        System.out.println("--------------");
        writeJedis.setex("hello",100,"world");
        System.out.println(readJedis.get("hello"));
    }
}
