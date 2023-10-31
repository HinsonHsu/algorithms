package org.hinson.sword;

import java.util.Deque;
import java.util.LinkedList;

public class Q31 {

    public boolean isPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Deque<Integer> stack = new LinkedList<>();

        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);

            while (popIndex < n && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();

    }
}
