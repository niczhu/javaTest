package com.test.consistenceHash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhuhp
 * @Date 2019/8/31
 */
public class Servers {

    //待添加入Hash环的服务器列表
    private static String[] servers = {
            "192.168.0.0",
            "192.168.0.1",
            "192.168.0.2",
            "192.168.0.3",
            "192.168.0.4"
    };

    public static final List<String> serverIps = Arrays.asList(
            "192.168.0.0",
            "192.168.0.1",
            "192.168.0.2",
            "192.168.0.3",
            "192.168.0.4"
    );

    // 随机权重算法 k-ip v-weight
    public static  final Map<String,Integer> randomWeight = new HashMap<String,Integer>();
    static {
        randomWeight.put("192.168.0.5",5);
        randomWeight.put("192.168.0.3",3);
        randomWeight.put("192.168.0.2",2);
    }

}
