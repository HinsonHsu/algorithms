package org.hinson.sword;

import org.hinson.leetcode.ListNode;

public class Q52 {

    public ListNode commonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;

        while (l1 != l2) {
            if (l1 == null) {
                l1 = pHead2.getNext();
            } else {
                l1 = l1.getNext();
            }

            if (l2 == null) {
                l2 = pHead1.getNext();
            } else {
                l2 = l2.getNext();
            }
        }

        return l1;
    }
}
