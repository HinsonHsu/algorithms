package org.hinson.sword;

import java.util.Arrays;
import java.util.List;

/**
 * 输出所有和为 S 的连续正数序列。例如和为 100 的连续序列有：
 *
 * [9, 10, 11, 12, 13, 14, 15, 16]
 * [18, 19, 20, 21, 22]。
 */
public class Q57_2 {

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
