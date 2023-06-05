package org.hinson.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 排序加双指针检索
 */
public class Question1146 {

    Map<Integer, TreeMap<Integer, Integer>> map;
    int snapId = 0;

    public Question1146(int length) {
        map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> tree = new TreeMap<>();
            tree.put(0, 0);
            map.put(i, tree);
        }
    }

    public void set(int index, int val) {
        map.get(index).put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> tree = map.get(index);
        return tree.floorEntry(snap_id).getValue();
    }
}
