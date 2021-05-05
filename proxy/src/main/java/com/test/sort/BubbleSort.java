package com.test.sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class BubbleSort {

    private static int[] aArr = {3, 4, 1, 5, 2};


    /**
     * 冒泡算法
     */
    public static void bubbleSort() {

        /**
         * 从0 开始，两两比较，大的往后沉;
         * 每遍历一趟只会有一个最大数往后沉;
         * 遍历趟数，
         * 两两比较次数
         *
         */
        for (int i = 0, len = aArr.length; i < len - 1; i++) {  // 遍历的趟数
            for (int j = 0; j < len - i - 1; j++) {  // 两两比较次数
                // 如果 j 比 j+1 大，则往后沉
                if (aArr[j] > aArr[j + 1]) {
                    aArr[j] = aArr[j] + aArr[j + 1];
                    aArr[j + 1] = aArr[j] - aArr[j + 1];
                    aArr[j] = aArr[j] - aArr[j + 1];
                }
            }
        }

    }


    public static void main(String[] args) {

        bubbleSort();

        System.out.println(JSON.toJSONString(aArr));

    }

}
