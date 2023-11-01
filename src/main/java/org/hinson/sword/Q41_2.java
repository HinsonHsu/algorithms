package org.hinson.sword;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *
 * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
 * 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 */
public class Q41_2 {

    private Queue<Character> q = new LinkedList<>();

    private final BitSet bitSet = new BitSet(128);
    private final BitSet bitSet2 = new BitSet(128);

    public void insert(char c) {
        int idx = c - 'a';
        if (!bitSet.get(idx)) {
            q.offer(c);
            bitSet.set(idx);
        } else {
            bitSet2.set(idx);
        }
    }

    public Character getFirstChar() {
        while (!q.isEmpty()) {
            Character c = q.poll();
            int idx = c - 'a';
            if (!bitSet2.get(idx)) {
                return c;
            }
        }
        return null;
    }


}
