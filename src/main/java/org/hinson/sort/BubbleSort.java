package org.hinson.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * created on 2022-07-27
 */
public class BubbleSort {

    public int[] sort(int[] nums) {
        // 拷贝原数组
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < arr.length; i++) {
            // 用于标记此次循环是否交换过，无交换则说明排序完成
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
