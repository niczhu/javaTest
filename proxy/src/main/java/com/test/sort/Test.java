package com.test.sort;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {
        int[] t = {10, 8, 19, 4, 8, 20, 1};
        int[] temp = new int[t.length];
        sort(t, 0, t.length - 1, temp);
        System.out.println(JSON.toJSONString(t));

        int[] t2 = {10, 8, 19, 4, 8, 20, 1};
        System.out.println("------quick sort----");
        quickSort(t2, 0, t2.length - 1);
        System.out.println(JSON.toJSONString(t2));

        System.out.println(tableSizeFor(13));
        new CopyOnWriteArrayList<>();
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.tryLock();

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
        while (l <= mid && r <= right) {
            temp[t++] = arr[l] >= arr[r] ? arr[r++] : arr[l++];
        }

        while (l <= mid) {
            temp[t++] = arr[l++];
        }

        while (r <= right) {
            temp[t++] = arr[r++];
        }
        // temp => arr
        for (int i : temp) {
            if (left <= right) {
                arr[left++] = i;
            }
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left > right) return;
        int base = getBase(nums, left, right);
        quickSort(nums, left, base - 1);
        quickSort(nums, base + 1, right);
    }

    public static int getBase(int[] nums, int left, int right) {
        int base = nums[left];
        while (left != right) {
            while (left < right && base <= nums[right]) {
                right--;
            }

            nums[left] = nums[right];

            while (left < right && base >= nums[left]) {
                left++;
            }

            nums[right] = nums[left];
        }
        nums[left] = base;
        return left;
    }

    private static int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }
}
