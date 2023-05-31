package org.hinson.leetcode;

import org.hinson.tree.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Question1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int i : to_delete) {
            toDeleteSet.add(i);
        }
        List<TreeNode> res = new LinkedList<>();
        if (!toDeleteSet.contains(root.val)) {
            res.add(root);
        }
        dfs(root, toDeleteSet, res);
        return res;
    }

    private TreeNode dfs(TreeNode root, Set<Integer> toDeleteSet, List<TreeNode> res) {
        if (root == null) {
            return null;
        }

        root.left = dfs(root.left, toDeleteSet, res);
        root.right = dfs(root.right, toDeleteSet, res);

        if (toDeleteSet.contains(root.val)) {
            // 需要删除当前节点
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
            root = null;
        }

        return root;
    }
}
