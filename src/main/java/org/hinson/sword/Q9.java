package org.hinson.sword;

import java.util.Deque;
import java.util.LinkedList;

public class Q9 {

    public Deque<Integer> in = new LinkedList<>();

    public Deque<Integer> out = new LinkedList<>();


    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            throw new Exception("queue is empty!");
        }
        return out.pop();
    }

}
