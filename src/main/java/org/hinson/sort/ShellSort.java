package org.hinson.sort;

/**
 * 希尔排序，插入排序的改进版
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序
 * created on 2022-07-27
 */
public class ShellSort {

    public int[] sort(int[] arr) {
        int len = arr.length;
        int tmp;
        for (int step = len / 2; step >= 1; step /= 2) {
            for (int i = step; i < len; i++) {
                tmp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = tmp;
            }
        }
        return arr;
    }
}
