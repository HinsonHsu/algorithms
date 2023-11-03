package org.hinson.sword;

import org.hinson.leetcode.ListNode;

/**
 * 有序链表，删除链表中重复的结点
 */
public class Q18_2 {

    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode next = head.getNext();
        if (head.getVal() == next.getVal()) {
            while (next != null && head.getVal() == next.getVal()) {
                next = next.getNext();
            }
            return deleteDuplication(next);
        } else {
            head.setNext(deleteDuplication(head.getNext()));
            return head;
        }
    }
}
