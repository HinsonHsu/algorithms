package org.hinson.sword;

import org.hinson.leetcode.ListNode;

/**
 * 反转链表
 */
public class Q24 {

    /**
     * 递归
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode next = head.getNext();

        head.next = null;

        ListNode newHead = reverseList(next);

        next.next = head;

        return newHead;
    }

    /**
     * 迭代，使用头插法
     */
    public ListNode reverseList0(ListNode head) {
        ListNode newList = new ListNode(-1);

        while (head != null) {
            ListNode next = head.getNext();

            head.next =  newList.getNext();

            newList.next = head;

            head = next;
        }
        return newList.getNext();
    }
}
