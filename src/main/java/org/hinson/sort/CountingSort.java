package org.hinson.sort;

import java.util.Arrays;

/**
 * created on 2022-07-29
 * 计数排序
 */
public class CountingSort implements ISort {

    public int[] sort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        int maxValue = getMaxValue(nums);

        return countingSort(arr, maxValue);
    }

    private int getMaxValue(int[] nums) {
        int maxValue = nums[0];
        for (int value : nums) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    private int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }
        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }
}
