package org.hinson.leetcode;

import org.hinson.tree.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 排序加双指针检索
 */
public class Question235 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
