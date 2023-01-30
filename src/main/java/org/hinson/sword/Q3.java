package org.hinson.sword;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q3 {


    public int find(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == i) continue;
            if (nums[num] == num) return num;

            // 循环置位：
            // 将当前i位置上的数放置到它应该去的位置，置换出来的数，换回到i位置，盯住i位置不动，继续循环置位。
            // 期间如果发现应该去的位置上躺着的已经是正确的数字了，则发现重复，return
            while (nums[i] != i) { // 在一次置位循环中，始终盯住i位置不动，以i位置为发货地，不断向外发送数字。
                // i位置上数应该发往nums[i]位置，置换出num这个数：
                num = nums[nums[i]];
                if (num == nums[i])
                    return num; // 发现重复
                nums[nums[i]] = nums[i];
                nums[i] = num;
            }
        }
        return 0;
    }
}
