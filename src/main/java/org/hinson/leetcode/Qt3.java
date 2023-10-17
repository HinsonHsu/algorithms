package org.hinson.leetcode;

import java.util.*;

public class Qt3 {

    public static void main(String[] args) {
        String s = " ";
        int res = new Qt3().lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            start = Math.max(map.getOrDefault(c, -1) + 1, start);
            max = Math.max(i - start + 1, max);
            map.put(c, i);
        }

        return max;
    }
}
