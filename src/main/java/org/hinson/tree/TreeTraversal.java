package org.hinson.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    /**
     * 先序遍历：递归实现
     */
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * 先序遍历：非递归实现
     */
    public static void preOrderTraversalNonRecurse(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || stack.size() > 0) {
            if (cur != null) {
                stack.push(cur);
                System.out.println(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    /**
     * 中序遍历：递归实现
     */
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root);
        inOrderTraversal(root.right);
    }

    /**
     * 中序遍历：非递归实现
     */
    public static void inOrderTraversalNonRecurse(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || stack.size() > 0) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println(cur);
                cur = cur.right;
            }
        }
    }

    /**
     * 后序遍历：递归实现
     */
    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root);
    }

    /**
     * 后序遍历：非递归实现
     */
    public static void postOrderTraversalNonRecurse(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || stack.size() > 0) {
            // 遍历到左下
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.right == null || cur.right == pre) {
                System.out.println(cur);
                pre = cur;
                cur = null;
            } else {
                stack.push(cur);
                cur = cur.right;
            }
        }
    }

    /**
     * 层序遍历
     */
    public static void levelTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
}
