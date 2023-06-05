package org.hinson.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Question2460 {

    public int[] applyOperations(int[] nums) {
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
            if (nums[i] == 0 && idx == -1) {
                idx = i;
            } else if (idx >= 0 && nums[i] > 0) {
                nums[idx] = nums[i];
                nums[i] = 0;
                idx++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                0,1
        };
        new Question2460().applyOperations(nums);
        System.out.println(Arrays.toString(nums));
    }
}
