package org.hinson.leetcode;

import java.util.Arrays;

public class Question5 {

    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        int max = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < s.length() * 2; i++) {
            int left = (i)/ 2;
            int right = (i + 1) / 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (max < (right - left - 1)) {
                max = right - left - 1;
                maxLeft = left;
                maxRight = right;
            }
        }
        return s.substring(maxLeft + 1, maxRight);
    }

    /**
     * dp的写法
     */
    public String longestPalindrome2(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        int maxlenth = 0;
        int maxLeft = 0;
        int maxRight = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else if(dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }

                    if (dp[i][j] && j - i + 1 > maxlenth) {
                        maxlenth = j - i + 1;
                        maxLeft = i;
                        maxRight = j;
                    }
                }
            }
        }
        for (boolean[] item : dp) {
            System.out.println(Arrays.toString(item));
        }
        return s.substring(maxLeft, maxRight + 1);
    }


    public static void main(String[] args) {
        // #b#a#b#a#d
        String s = "cbabbc";
        String res = new Question5().longestPalindrome2(s);
        System.out.println(res);
    }
}
