package org.hinson.sort;

import java.util.Arrays;

public class RadixSort implements ISort {

    public int[] sort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        int maxDigit = getMaxDigit(arr);

        return radixSort(arr, maxDigit);
    }

    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLength(maxValue);
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    private int getNumLength(long num) {
        if (num == 0) {
            return 1;
        }
        int length = 0;
        for (long tmp = num; tmp != 0; tmp /= 10) {
            length++;
        }
        return length;
    }

    private int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            int[][] counter = new int[mod * 2][0];

            for (int k : arr) {
                int bucket = ((k % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], k);
            }
            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }
        return arr;
    }

    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
