package com.test.redis;

import org.omg.CORBA.OBJECT_NOT_EXIST;
import redis.clients.jedis.*;
import redis.clients.jedis.params.SetParams;

public class jedisLock {

    private static Jedis jedis;

    private static final String IP_KEY= "ip:1.0";

    static SetParams setParams = SetParams.setParams().nx().ex(10);

    static {
        jedis = JedisClient.getJedis();
    }

    public static void main(String[] args) throws Exception{

        jedis.del(IP_KEY);

        for (int i = 0; i < 5; i++) {
            boolean rst = lock(IP_KEY,"1000",3000);
            System.out.println("==>"+rst);
            Thread.sleep(1000);
            if(i ==3){
                unlock(IP_KEY);
            }
        }

        jedis.close();
        JedisClient.closePool();
    }

    /**
     * jedis setnx + expire setParams 实现锁
     * @param
     * @param timeOutMillis
     * @return
     */
    public static boolean lock(String key,String value,int timeOutMillis){
        Jedis jedis = JedisClient.getJedis();
        long start = System.currentTimeMillis();

        try {
            for (; ; ) {

                // 使用setparams命令，可以防止多个命令执行中redis宕机产生的影响
                String lock = jedis.set(key, value, setParams);

                if ("OK".equals(lock)) {
                    return true;
                }

                // timeout
                long l = System.currentTimeMillis() - start;
                if (l > timeOutMillis) {
                    return false;
                }

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }finally {
            System.out.println("close");
            jedis.close();
        }
    }

    public static boolean unlock(String key){
        try{
            Jedis jedis = JedisClient.getJedis();
            Long del = jedis.del(key);

            System.out.println("key ["+key +"] has unlock==");

            if(del==1)
                return true;
        }
        finally {
            jedis.close();
        }
        return false;
    }

}
