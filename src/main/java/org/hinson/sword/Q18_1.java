package org.hinson.sword;

import org.hinson.leetcode.ListNode;

/**
 * 在 O(1) 时间内删除链表节点
 */
public class Q18_1 {

    public ListNode deleteNode(ListNode head, ListNode toDeletedNode) {
        if (toDeletedNode == null) {
            return head;
        }
        if (toDeletedNode.getNext() != null) {
            ListNode next = toDeletedNode.getNext();
            toDeletedNode.setVal(next.getVal());
            toDeletedNode.setNext(next.getNext());
        } else {
            ListNode node = head;
            while (node.getNext() != toDeletedNode) {
                node = node.getNext();
            }
            node.setNext(toDeletedNode.getNext());
        }
        return head;
    }
}
