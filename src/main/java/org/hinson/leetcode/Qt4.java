package org.hinson.leetcode;

public class Qt4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int len = nums1.length + nums2.length;

        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;

        while (cut1 <= nums1.length) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len / 2 - cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) {
                cutR = cut1 - 1;
            } else if (L2 > R1) {
                cutL = cut1 + 1;
            } else {
                if (len % 2 == 0) {
                    L1 = Math.max(L1, L2);
                    R1 = Math.min(R1, R2);
                    return (L1 + R1) / 2;
                } else {
                    R1 = Math.max(R1, R2);
                    return R1;
                }
            }
        }
        return -1;
    }
}