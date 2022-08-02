package org.hinson.sort;

import java.util.Arrays;

/**
 * 归并排序，空间复杂度O(N)
 * created on 2022-07-27
 */
public class MergeSort implements ISort {

    public int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = sort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sort(Arrays.copyOfRange(nums, mid, nums.length));

        int[] arr = new int[left.length + right.length];
        int m = 0, i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[m++] = left[i++];
            } else {
                arr[m++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[m++] = left[i++];
        }
        while (j < right.length) {
            arr[m++] = right[j++];
        }
        return arr;
    }
}
