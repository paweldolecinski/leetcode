package pl.dolecinski.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 6, 0, 0, 0};
        int m = 4;

        int[] nums2 = {2, 4, 5};
        int n = 3;

        new Solution().merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    static class Solution {

        public void merge(int[] nums1, int m, int[] nums2, int n) {

            int insertPosition = m + n - 1;

            m--;
            n--;
            while (n >= 0) {
                if (m >= 0 && nums1[m] >= nums2[n]) {
                    nums1[insertPosition--] = nums1[m--];
                } else {
                    nums1[insertPosition--] = nums2[n--];
                }
            }
        }


    }
}
