package com.test.leetcode.arr;

import com.alibaba.fastjson.JSON;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * @param nums
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 以i位置的值结尾的连续子数组最大值
        int[] dp = new int[nums.length];

        //base case
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        System.out.println(JSON.toJSONString(dp));

        int rest = Integer.MIN_VALUE;
        for (int j : dp) {
            rest = Math.max(j, rest);
        }

        return rest;
    }
}
