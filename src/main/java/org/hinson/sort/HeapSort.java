package org.hinson.sort;

import java.util.Arrays;

/**
 * created on 2022-07-29
 * 堆排序
 */
public class HeapSort implements ISort {

    public int[] sort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        int len = arr.length;

        buildMaxHeap(arr);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, i, 0);
            len--;
            heapify(arr, i, len);
        }

        return arr;
    }

    private void buildMaxHeap(int[] arr) {
        int len = arr.length;
        for (int i = (len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[i]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[i]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
