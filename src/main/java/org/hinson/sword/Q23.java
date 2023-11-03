package org.hinson.sword;

import org.hinson.leetcode.ListNode;

public class Q23 {

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.getNext() == null) {
            return null;
        }
        ListNode slow = pHead.getNext().getNext();
        ListNode fast = pHead.getNext();

        while (slow != fast) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        fast = pHead;

        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;
    }
}
