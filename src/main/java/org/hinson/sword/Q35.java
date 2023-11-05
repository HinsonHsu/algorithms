package org.hinson.sword;

public class Q35 {

    public RandomListNode copyListNode(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        cur = head;
        while (cur != null) {
            RandomListNode clone = head.next;
            RandomListNode random = cur.random;
            RandomListNode cloneRandom = random.next;
            clone.random = cloneRandom;
            cur = clone.next;
        }

        cur = head;
        RandomListNode clonedHead = head.next;
        // 巧妙的地方
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return clonedHead;
    }



    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
