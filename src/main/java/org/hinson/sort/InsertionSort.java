package org.hinson.sort;

import java.util.Arrays;

/**
 * 插入排序
 * created on 2022-07-27
 */
public class InsertionSort implements ISort {

    public int[] sort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
