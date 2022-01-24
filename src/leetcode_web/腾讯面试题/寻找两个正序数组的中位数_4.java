package leetcode_web.腾讯面试题;

import org.junit.Test;

public class 寻找两个正序数组的中位数_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) return 0;
        if (nums1.length == 0 && nums2.length == 0) return 0;

        int mid1 = (nums1.length + nums2.length + 1) / 2;
        int mid2 = (nums1.length + nums2.length + 2) / 2;


        int midNum1 = 0;
        int midNum2 = 0;

        boolean flag = mid1 != mid2;

        double mid = 0;
        int l = 0;
        int r = 0;
        int c = 1;


        System.out.println(mid1 + "    " + mid2);

        while ((c - 1) != mid2) {
            if ((c - 1) < mid1) {
                if (l + 1 <= nums1.length && r + 1 <= nums2.length) {
                    if (nums1[l] <= nums2[r]) {
                        midNum1 = nums1[l];
                        l++;
                        c++;
                    } else {
                        midNum1 = nums2[r];
                        r++;
                        c++;
                    }
                } else if (l + 1 > nums1.length) {
                        midNum1 = nums2[r];
                        r++;
                        c++;

                } else if (r + 1 > nums2.length) {
                        midNum1 = nums1[l];
                        l++;
                        c++;

                }
                mid = midNum1;
            } else if ((c - 1) == mid1 && flag == true) {
                if (l + 1 <= nums1.length && r + 1 <= nums2.length) {
                    if (nums1[l] <= nums2[r]) {
                        midNum2 = nums1[l];
                        l++;
                        c++;
                    } else {
                        midNum2 = nums2[r];
                        r++;
                        c++;
                    }
                } else if (l + 1 > nums1.length) {
                        midNum2 = nums2[r];
                        r++;
                        c++;

                } else if (r + 1 > nums2.length) {
                        midNum2 = nums1[l];
                        l++;
                        c++;
                }
                mid = (midNum1 + midNum2) / 2.0;
            }


        }


        return mid;
    }

    @Test
    public void testFindMedianSortedArrays() {

        int[] nums1 = {};
        int[] nums2 = {1};


        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
}
