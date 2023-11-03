package org.hinson.sword;

import org.hinson.leetcode.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 从尾到头反过来打印出每个结点的值。
 */
public class Q6 {

    /**
     * 递归
     */
    public List<Integer> printListFromTailToHead(ListNode listNode) {
        List<Integer> ret = new LinkedList<>();

        addNode(ret, listNode);

        return ret;
    }

    private void addNode(List<Integer> ret, ListNode node) {
        if (node == null) {
            return;
        }
        if (node.getNext() != null) {
            addNode(ret, node.getNext());
        }
        ret.add(node.getVal());
    }

    /**
     * 栈
     */
    public List<Integer> printListFromTailToHead1(ListNode listNode) {
        Deque<Integer> stack = new LinkedList<>();
        while (listNode != null) {
            stack.push(listNode.getVal());
            listNode = listNode.getNext();
        }
        List<Integer> ret = new LinkedList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }

    /**
     * 反转链表
     */
    public List<Integer> printListFromTailToHead2(ListNode listNode) {
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.getNext();

            listNode.setNext(head.getNext());
            head.setNext(listNode);

            listNode = memo;
        }

        head = head.getNext();

        List<Integer> ret = new LinkedList<>();
        while (head != null) {
            ret.add(head.getVal());
            head = head.getNext();
        }

        return ret;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.setNext(node2);
        node2.setNext(node3);

        System.out.println(new Q6().printListFromTailToHead2(node1));
    }
}
