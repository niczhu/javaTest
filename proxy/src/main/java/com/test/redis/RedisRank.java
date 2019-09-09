package com.test.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * redis实现实时排名
 *
 */
public class RedisRank {

    private static final String RANK_KEY = "rank:local:201909";

    private static Map<String,Double> rankMap = new HashMap<>();

    static {
        rankMap.put("k1",1d);
        rankMap.put("k2",2d);
        rankMap.put("k3",3d);
        rankMap.put("k4",4d);
        rankMap.put("k5",5d);
    }

    public static void main(String[] args) throws Exception{

        Jedis jedis = JedisClient.getJedis();
        for(Map.Entry entry : rankMap.entrySet()){
            jedis.zincrby(RANK_KEY,(double)entry.getValue(),(String)entry.getKey());
        }

        System.out.println(jedis.zrangeWithScores(RANK_KEY,0,-1));
        Random random = new Random();

        for (int i = 0; i < 5; i++) {

            Object[] ks = rankMap.keySet().toArray();

            jedis.zincrby(RANK_KEY,new Random().nextInt(10),(String)ks[i]);

        }

        System.out.println(jedis.zrangeWithScores(RANK_KEY,0,-1));

        Set<Tuple> t = jedis.zrevrangeWithScores(RANK_KEY, 0, -1);

        /**
         * 相同分值以时间戳进行二级排序
         * score = Score *10^10 + 9999999999-unix_time 保存到redis中。
         * Unix_time是以秒为单位的当前时间戳。时间戳最高10位，
         * 故低10位是时间戳，高位是得分，因为double类型精度最高为16位，故最高保存的真实分值是6位数！
         *
         */
        for (Tuple tuple : t) {
//            System.out.println(tuple.getElement()+"=>" + tuple.getScore());
            double score = tuple.getScore()*10000000000d +9999999999l-System.currentTimeMillis()/1000d;

            System.out.println(tuple.getElement()+" =>" + tuple.getScore() +" => "+score + " =反向score=>"+(int)(score/10000000000l));

            Thread.sleep(500);
        }

    }
}
