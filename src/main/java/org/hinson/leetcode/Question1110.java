package org.hinson.leetcode;

import org.hinson.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        process(root, to_delete, res);
        return res;
    }

    public void process(TreeNode root, int[] to_delete, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        if (to_delete.length == 0) {
            return;
        }

        TreeNode left = root.left;

        if (left != null) {
            if (inDelete(left, to_delete)) {
                root.left = null;
                res.add(left);
            }
            process(left, to_delete, res);
        }

        TreeNode right = root.right;
        if (right != null) {
            if (inDelete(right, to_delete)) {
                root.right = null;
                res.add(right);
            }
            process(right, to_delete, res);
        }
    }

    private boolean inDelete(TreeNode node, int[] to_delete) {
        for (int item : to_delete) {
            if (item == node.val) {
                return true;
            }
        }
        return false;
    }

}
