package com.test.consistenceHash;

import java.util.Map;
import java.util.Random;

/**
 * @Author zhuhp
 * @Date 2019/8/31
 *
 * 负载均衡
 *
 * 随机权重算法
 *
 *
 */
public class RandomWeight {

    public static  String getServer(){
        // 所有权重之和
        int totalWeight = 0;
        // todo:如果所有权重相等随机选一个ip即可

        for (Map.Entry<String, Integer> entry : Servers.randomWeight.entrySet()) {
            totalWeight += entry.getValue();
        }

        /**
         * weight[5,3,2]
         * 假设随机数：offset =7;
         * 循环权重集合，比较offset是否小于当前权重，不成立则 offset = offset - 当前权重,继续循环比较下一个
         * offset < 5 ? ,false ,所以不在[0,5)区间，offset = offset -5;
         * offset =2; offset < 3 ? ，true，故在【5，8）区间；
         *
         */
        Random random = new Random();
        int offset = random.nextInt(totalWeight);
        System.out.print("offset = "+offset + "  ");

        for (Map.Entry<String, Integer> entry : Servers.randomWeight.entrySet()) {

            System.out.print(" weight= "+entry.getValue() + " ");

            if(offset < entry.getValue()){

                System.out.println( " -> " + entry.getKey()+" "+entry.getValue());

                return entry.getKey();
            }
            offset = offset - entry.getValue();
        }

        return (String)Servers.randomWeight.values().toArray()[random.nextInt(totalWeight)];
    }

    public static void main(String[] ss){
        // foreach 10
        for (int i = 0; i < 6; i++) {
            getServer();
        }

    }

}
