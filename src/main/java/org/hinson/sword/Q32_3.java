package org.hinson.sword;

import org.hinson.tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 之字形打印二叉树
 */
public class Q32_3 {

    public List<List<Integer>> printTree(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        boolean reverse = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpList = new LinkedList<>();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                tmpList.add(node.val);
                if (reverse) {
                    Collections.reverse(tmpList);
                }
                if (tmpList.size() > 0) {
                    ret.add(tmpList);
                }
            }
        }
        return ret;
    }
}
