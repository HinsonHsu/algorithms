package org.hinson.sword;

import java.util.Deque;
import java.util.LinkedList;

public class Q30 {

    private final Deque<Integer> dataStack = new LinkedList<>();
    private final Deque<Integer> minStack = new LinkedList<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public int pop() {
        int res = dataStack.pop();
        dataStack.pop();
        return res;
    }

    public int top() {
        return dataStack.peek();
    }
}
