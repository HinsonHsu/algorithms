package org.hinson.sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在有序数组中找出两个数，使得和为给定的数 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
 */
public class Q57_1 {

    /**
     * 关键：乘积最大即要求差值最大
     */
    public List<Integer> findTwoNums(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int cur = nums[i] + nums[j];
            if (cur == target) {
                return Arrays.asList(nums[i], nums[j]);
            } else if (cur > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;

    }
}
