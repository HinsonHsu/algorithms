package org.hinson.sort;

import java.util.Arrays;

/**
 * created on 2022-07-29
 * 基数排序
 */
public class BucketSort {

    public int[] sort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        return bucketSort(arr, 5);
    }

    private int[] bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[1];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][0];

        for (int j : arr) {
            int index = (j - minValue) / bucketSize;
            buckets[index] = arrAppend(buckets[index], j);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            Arrays.sort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }

    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        // 插入排序
        int j = arr.length - 1;
        while (j > 0 && arr[j - 1] > arr[j]) {
            swap(arr, j - 1, j);
        }

        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
