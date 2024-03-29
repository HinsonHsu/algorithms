package org.hinson.sword;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回 。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Q8 {

    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = parent;
            }
        }
        return null;
    }

    static class TreeLinkNode {

        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null; // 指向父结点的指针

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
