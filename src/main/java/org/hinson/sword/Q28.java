package org.hinson.sword;

import org.hinson.tree.TreeNode;

/**
 * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 */
public class Q28 {

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        } else if (p1 == null || p2 == null) {
            return false;
        }
        if (p1.val != p2.val) {
            return false;
        }
        return isSymmetrical(p1.left, p2.right) && isSymmetrical(p1.right, p2.left);
    }
}
