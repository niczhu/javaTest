package com.test.sort;

import com.alibaba.fastjson.JSON;

public class MergeSort {
    // 归并算法
    public static void main(String[] args) {
        int[] arr = {10, 4, 3, 6, 2, 8, 5};
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);

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
            if (arr[l] <= arr[r]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[r++];
            }
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


}
