package org.hinson.sort;

/**
 * 快速排序
 * created on 2022-07-27
 */
public class QuickSort implements ISort {

    public int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int tmp = nums[start];
        int left = start + 1;
        int right = end;
        while (left != right) {
            while (left < right && nums[right] >= tmp) {
                right--;
            }
            while (left < right && nums[left] <= tmp) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        nums[start] = nums[left];
        nums[left] = tmp;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
