package org.hinson.leetcode;

import org.hinson.tree.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Question2559 {

    private static final Set<Character> set = new HashSet<Character>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
    }};

    /**
     * 前缀和
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] sum = new int[words.length + 1];

        int idx = 0;
        for (String word : words) {
            if (set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1))) {
                sum[idx + 1] = sum[idx] + 1;
            } else {
                sum[idx + 1] = sum[idx];
            }
            idx++;
        }
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            res[i] = sum[query[1] + 1] - sum[query[0]];
        }
        return res;
    }
}
