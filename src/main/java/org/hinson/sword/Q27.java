package org.hinson.sword;

import org.hinson.tree.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Q27 {

    public TreeNode mirrorTree(TreeNode pHead) {
        if (pHead == null) {
            return null;
        }
        TreeNode left = pHead.left;
        TreeNode right = pHead.right;
        swap(left, right);
        mirrorTree(left);
        mirrorTree(right);
        return pHead;
    }

    private void swap(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            int val1 = node1.val;
            node1.val = node2.val;
            node2.val = val1;
        }
    }
}
