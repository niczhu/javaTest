package com.test.sort;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MergeSort {
    // 归并算法
    public static void main(String[] args) {
        int[] arr = {10, 4, 3, 6, 2, 8, 5};
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);

        String[] strs = {"ab", "a", "a"};
        System.out.println(longestCommonPrefix(strs));

        System.out.println(JSON.toJSONString(arr));
    }


    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) >> 1;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0;

        // 左右数据长度相等时
        while (l <= mid && r <= right) {
//            if (arr[l] <= arr[r]) {
//                temp[t++] = arr[l++];
//            } else {
//                temp[t++] = arr[r++];
//            }
            temp[t++] = arr[l] <= arr[r] ? arr[l++] : arr[r++];
        }

        // 左右数据长度不等时
        while (l <= mid) {
            temp[t++] = arr[l++];
        }
        while (r <= right) {
            temp[t++] = arr[r++];
        }

        // temp => arr;
        for (int tValue : temp) {
            if (left <= right) {
                arr[left++] = tValue;
            }
        }
    }

    private static void sort2(int[] arr) {
    }

    private static int[] merge2(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < result.length; i++) {
            if (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex] < right[rightIndex]) {
                    result[i] = left[leftIndex];
                    leftIndex++;
                } else {
                    result[i] = right[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex == left.length) {
                result[i] = right[rightIndex];
                rightIndex++;
            } else if (rightIndex == right.length) {
                result[i] = left[leftIndex];
                leftIndex++;
            }
        }
        return result;
    }


    /**
     * 最长前缀字符串
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int minLen = strs[0].length();
        String rest = "";
        for (int i = 0; i < minLen; i++) {
            char prefix = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i > strs[j].length() - 1) {
                    return rest;
                } else {
                    if (strs[j].charAt(i) != prefix) {
                        return rest;
                    }
                }

            }
            rest += prefix;
        }
        return rest;
    }



}
