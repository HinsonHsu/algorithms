package org.hinson.leetcode;

import org.hinson.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question662 {

    int max;

    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root, res, 1, 1);
        return max;
    }

    private void dfs(TreeNode node, List<Integer> res, int level, int i) {
        if (node == null) {
            return;
        }
        if (level > res.size()) {
            res.add(i);
        }
        max = Math.max(max, i - res.get(level) + 1);
        dfs(node.left, res, level + 1, i * 2);
        dfs(node.right, res, level + 1, i * 2 + 1);
    }
}
