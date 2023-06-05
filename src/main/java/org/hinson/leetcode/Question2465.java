package org.hinson.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 排序加双指针检索
 */
public class Question2465 {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        Set<Integer> set = new HashSet<>();
        while (left < right) {
            set.add(nums[left] + nums[right]);
            left ++;
            right --;
        }
        return set.size();
    }
}
