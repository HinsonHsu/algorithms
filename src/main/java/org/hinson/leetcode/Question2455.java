package org.hinson.leetcode;

public class Question2455 {

    public int averageValue(int[] nums) {
        int sum = 0;
        int size = 0;
        for (int num : nums) {
            if ((num % 3== 0) && ((num & 1) == 0)) {
                sum += num;
                size++;
            }
        }
        if (size == 0) {
            return 0;
        }
        return sum / size;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,10,12,15};
        int res = new Question2455().averageValue(nums);
        System.out.println(res);
    }
}
