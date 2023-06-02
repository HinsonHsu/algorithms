package org.hinson.leetcode;

public class Question4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int len = len1 + len2;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;
        int cutLen = len / 2;

        while (cut1 <= len1) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = cutLen - cut1;
            double l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double r1 = cut1 == 0 ? Integer.MAX_VALUE : nums1[cut1];
            double r2 = cut2 == 0 ? Integer.MAX_VALUE : nums2[cut2];
            if (l1 > r2) {
                cutR = cut1 - 1;
            } else if (l2 > r1) {
                cutL = cut1 + 1;
            } else {
                if (cutLen % 2 == 0) {
                    l1 = Math.max(l1, l2);
                    r1 = Math.min(r1, r2);
                    return (l1 + r1) / 2;
                } else {
                    r1 = Math.min(r1, r2);
                    return r1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "codec:cpu:samsung technologies, inc exynos e1080";
        String s2 = "codec:cpu:samsung technologies, inc exynos e1080";

        String s5 = ") Core(TM) i7-8700B CPU @ 3.20GHz";

        System.out.println(s1.contains(" "));

        String tmp = " ";

        String tmp2 = "\\u0020";

        String s44 = "HTC Legend";

        String s3 = s1.replaceAll("\\u00A0", " ");

        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s3));
        System.out.println(s1.equals(s2));

//        System.out.println("\\u00A0".equals(tmp));
//        for (int i = 0; i < s2.length(); i++) {
//            System.out.println(s2.charAt(i) + "=" + Integer.valueOf(s2.charAt(i)));
//        }

    }
}
