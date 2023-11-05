package org.hinson.sword;

import org.hinson.leetcode.ListNode;

/**
 * 合并两个排序的链表
 */
public class Q25 {

    /**
     * 递归
     */
    public ListNode merge(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.getVal() <= l2.getVal()) {
            l1.next = merge(l1.getNext(), l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.getNext());
            return l2;
        }
    }

    /**
     * 迭代
     */
    public ListNode merge0(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.getVal() <= l2.getVal()) {
                cur.next = l1;
                l1 = l1.getNext();
            } else {
                cur.next = l2;
                l2 = l2.getNext();
            }
            cur = cur.getNext();
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.getNext();
    }
}
