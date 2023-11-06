package org.hinson.sword;

import org.hinson.tree.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（我们约定空树不是任意一个树的子结构）
 */
public class Q26 {

    public boolean isSubTree(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return false;
        }
        return isSubTreeWithRoot(a, b) || isSubTree(a.left, b) || isSubTree(a.right, b);
    }


    public boolean isSubTreeWithRoot(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSubTreeWithRoot(a.left, b.left) && isSubTreeWithRoot(a.right, b.right);
    }
}
