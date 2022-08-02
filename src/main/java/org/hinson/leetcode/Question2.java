package org.hinson.leetcode;

/**
 * 2. 两数相加
 * 非负数
 * 2->4->3
 * 5->6->4
 * 7->0->8
 */
public class Question2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode();
        ListNode head = dummyHead;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            head.next = new ListNode(sum);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            head.next = new ListNode(sum);
            head = head.next;
        }
        if (carry > 0) {
            head.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
