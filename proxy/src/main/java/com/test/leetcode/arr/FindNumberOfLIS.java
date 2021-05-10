package com.test.leetcode.arr;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class FindNumberOfLIS {
    // 最长递增子序列
    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 4, 7};
        int[] nums = {2, 2, 2, 2, 2};

        System.out.println(findNumberOfLIS(nums));

    }

    // 最长递增子序列个数
    public static int findNumberOfLIS(int[] nums) {
        if (nums.length == 1) return 1;

        // nums[i]结尾的最长递增子序列长度
        int[] dpLen = new int[nums.length];
        // nums[i]结尾的最长递增子序列的个数
        int[] dpCount = new int[nums.length];

        Arrays.fill(dpCount, 1);
        Arrays.fill(dpLen, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dpLen[i] < dpLen[j] + 1) { // 新找到一个最长子序列
                        dpLen[i] = dpLen[j] + 1;
                        dpCount[i] = dpCount[j];
                    } else if (dpLen[i] == dpLen[j] + 1) { //
                        dpCount[i] = dpCount[i] + dpCount[j];
                    }
                }
            }
        }

        System.out.println(JSON.toJSONString(dpLen));
        System.out.println(JSON.toJSONString(dpCount));

        int max = 0;
        int rest = 0;
        for (int i = 0; i < dpLen.length; i++) {
            if (dpLen[i] > max) {
                max = dpLen[i];
            }
        }

        for (int i = 0; i < dpLen.length; i++) {
            if (max == dpLen[i]) rest += dpCount[i];
        }

        return rest;

    }


    /**
     * 最长递增子序列长度
     *
     * @param nums
     * @return
     */
    public static int maxLongOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;

        // 定义dp[i] 表示nums[i]结尾的最长递增子序列长度
        // base case
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] < 1) dp[i] = 1;
        }

        int rest = 1;
        for (int i : dp) {
            rest = Math.max(i, rest);
        }
        return rest;
    }
}
