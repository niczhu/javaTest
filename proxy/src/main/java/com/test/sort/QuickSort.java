package com.test.sort;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class QuickSort {

    private static int[] data = {3, 5, 2, 1, 4, 10};

    public static void main(String[] args) throws InterruptedException {
        doQuick(data, 0, data.length - 1);
//        getBase(data, 0, data.length - 1);
        System.out.println(JSON.toJSONString(data));
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        Semaphore semaphore = new Semaphore(1);
        semaphore.acquire();
        semaphore.release();
        CountDownLatch countDownLatch = new CountDownLatch(4);
        countDownLatch.await();
        countDownLatch.countDown();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);


    }

    public static void doQuick(int[] arr, int left, int right) {
        if (left > right) return;
        int base = getBase(arr, left, right);
        doQuick(arr, left, base - 1);
        doQuick(arr, base + 1, right);
    }


    public static int getBase(int[] arr, int left, int right) {
        int base = arr[left];

        while (left != right) {
            while (left < right && arr[right] >= base) {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] <= base) {
                left++;
            }
            arr[right] = arr[left];
        }

        //base 赋值
        arr[left] = base;
        return left;
    }
}
