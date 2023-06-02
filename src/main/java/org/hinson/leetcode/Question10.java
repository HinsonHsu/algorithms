package org.hinson.leetcode;

public class Question10 {

    /**
     * aaa
     * a.*
     */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        dp[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                char pc = p.charAt(i);
                char sc = s.charAt(j);
                if (pc == sc || pc == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pc == '*') {
                    char lastPc = p.charAt(i - 1);
                    if (lastPc == '.' || lastPc == sc) {
                        dp[i + 1][j + 1] = dp[i + 1][j];
                    }
                }
            }
        }

        return dp[p.length()][s.length()];
    }

    public boolean isMatch2(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*')
                match[0][j] = match[0][j - 2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    match[i][j] = match[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    match[i][j] = match[i][j - 2] || (match[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }
        return match[m][n];
    }

    public static void main(String[] args) {
        String p = "ba*";
        String s = "baa";
        boolean res = new Question10().isMatch(s, p);
        System.out.println(res);
    }
}
