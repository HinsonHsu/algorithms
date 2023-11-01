package org.hinson.sword;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * <p>
 * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 */
public class Q59 {


    /**
     * 时间复杂度O(N*logM) 空间复杂度O(M)
     */
    public List<Integer> maxInWindows(int[] nums, int size) {
        List<Integer> ret = new LinkedList<>();

        if (size > nums.length || size < 1) {
            return ret;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < size; i++) {
            heap.add(nums[i]);
        }

        ret.add(heap.peek());

        for (int i = 0, j = size; j < nums.length; i++, j++) {
            heap.remove(nums[i]);
            heap.add(nums[j]);
            ret.add(heap.peek());
        }
        return ret;
    }


}
