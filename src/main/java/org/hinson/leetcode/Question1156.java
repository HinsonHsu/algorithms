package org.hinson.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 */
public class Question1156 {

    public int maxRepOpt1(String text) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : text.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            count += 1;
            map.put(c, count);
        }
        int res = 0;
        for (int i = 0; i < text.length(); ) {
            int j = i;
            while (j < text.length() && text.charAt(i) == text.charAt(j)) {
                j++;
            }
            int curCnt = j - i;

            if (curCnt < map.get(text.charAt(i)) && (j < text.length() || i > 0)) {
                res = Math.max(res, curCnt + 1);
            }

            int k = j + 1;
            while (k < text.length() && text.charAt(k) == text.charAt(i)) {
                k++;
            }
            res = Math.max(res, Math.min(k - i, map.get(text.charAt(i))));
            i = j;
        }
        return res;
    }
}
