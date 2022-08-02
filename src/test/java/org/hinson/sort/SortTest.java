package org.hinson.sort;

import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = generateNums();
        int[] newNums = bubbleSort.sort(nums);
        System.out.println(isSorted(newNums));
    }

    private static int[] generateNums() {
        int[] nums = new int[1000];
        int i = 0;
        Random random = new Random();
        while (i < nums.length) {
            nums[i++] = random.nextInt(1000);
        }
        return nums;
    }

    private static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
