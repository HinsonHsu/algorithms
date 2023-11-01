package org.hinson.sword;

import java.util.PriorityQueue;

public class Q41 {

    /**
     * 大顶堆
     */
    private PriorityQueue<Integer> left = new PriorityQueue<>();

    /**
     * 小顶堆
     */
    private PriorityQueue<Integer> right = new PriorityQueue<>((o1, o2) -> o2 - o1);

    private int N;


    public void insert(int val) {
        if (N % 2 == 0) {
            // 右边增加一个
            left.add(val);
            right.add(left.poll());
        } else {
            // 左边增加一个
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double) right.peek();
        }
    }


}
