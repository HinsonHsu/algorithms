package org.hinson.leetcode;

public class Qt6 {

    public String convert(String s, int numRows) {
        int sLen = s.length();
        StringBuilder sb = new StringBuilder();
        int circle = 2 * numRows - 2;
        if (circle == 0 || circle < sLen) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            int start1 = i;
            while (start1 < sLen) {
                sb.append(s.charAt(start1));
                int end1 =  start1 - (start1 % circle) + circle - i;
                if (i != 0 && i != numRows - 1 && end1 < sLen) {
                    sb.append(s.charAt(end1));
                }
                start1 += circle;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "ABCDE";
        String res = new Qt6().convert(s, 4);
        System.out.println(res);
    }
}
