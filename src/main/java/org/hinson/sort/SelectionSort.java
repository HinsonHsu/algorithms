package org.hinson.sort;

import java.util.Arrays;

/**
 * 选择排序
 * created on 2022-07-27
 */
public class SelectionSort implements ISort {

    public int[] sort(int[] nums) {

        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(arr, i, min);
            }
        }
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
