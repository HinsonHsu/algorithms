package org.hinson.leetcode;

import org.hinson.tree.TreeNode;

/**
 * 排序加双指针检索
 */
public class Question1915 {


    public long wonderfulSubstrings(String word) {
        int[] cnt = new int[1024];
        cnt[0] = 1; // 初始前缀和为 0，需将其计入出现次数
        long ans = 0L;
        for (int i = 0, sum = 0; i < word.length(); ++i) {
            sum ^= 1 << (word.charAt(i) - 'a'); // 计算当前前缀和
            ans += cnt[sum]; // 所有字母均出现偶数次
            for (int j = 1; j < 1024; j <<= 1) // 枚举其中一个字母出现奇数次
                ans += cnt[sum ^ j]; // 反转该字母的出现次数的奇偶性
            ++cnt[sum]; // 更新前缀和出现次数
        }
        return ans;
    }

    public static void main(String[] args) {
        long res = new Question1915().wonderfulSubstrings("aba");
        System.out.println(res);
    }
}
