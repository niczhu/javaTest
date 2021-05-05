package com.test.sort;

import com.alibaba.fastjson.JSON;

public class InsertSort {

    private static int[] aArr = {3, 4, 1, 5, 2};

    /**
     * 查入排序
     * <p> O(n^2) </p>
     */
    public static void doInsertSort() {

        for (int i = 1, len = aArr.length; i < len; i++) {  //每次插入的值(要比较的值)

            for (int j = i; j > 0; j--) {

                // j-1 => 已经排好序的数组的最大值; j=>将要插入的值
                if (aArr[j] < aArr[j - 1]) {
                    int temp = aArr[j];
                    aArr[j] = aArr[j - 1];
                    aArr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

    }

    // 思路如下：
    // 4 2 3 1
    // 第一步：   4
    // 第二步:  2 4
    // 第三步:  2 3 4
    // 第四部步: 1 2 3 4

    public static void main(String[] args) {
        doInsertSort();
        System.out.println(JSON.toJSONString(aArr));
    }
}
