package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/reverse-pairs/
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 */
public class ReversePairs {

    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 3, 2, 3, 1}, 2),
            Arguments.of(new int[]{2, 4, 3, 5, 1}, 3),
            Arguments.of(new int[]{4, 1, 5, 3, 8, 2}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] input, int expected) {
        assertEquals(expected, new ReversePairs.Solution().reversePairs(input));
    }

    static class Solution {

        public int reversePairs(int[] nums) {
            if (nums == null || nums.length < 2) return 0;
            return mergesort(nums, 0, nums.length - 1);
        }

        int mergesort(int[] nums, int left, int right) {
            if (left < right) {
                int mid = left + (right - left) >> 1;
                int counter = mergesort(nums, left, mid)
                    + mergesort(nums, mid + 1, right)
                    + countLocalPairs(nums, left, mid, right);

                merge(nums, left, mid, right);
                return counter;
            }
            return 0;
        }

        private int countLocalPairs(int[] nums, int left, int mid, int right) {
            int counter = 0;
            int j = mid + 1;
            for (int i = left; i <= mid; i++) {
                while (j <= right && nums[i] > 2L * nums[j]) j++;
                counter += j - (mid + 1);
            }
            return counter;
        }

        private void merge(int[] nums, int left, int mid, int right) {

            if (nums[mid] <= nums[mid + 1]) {
                return;
            }

            int ln = mid - left + 1;
            int rn = right - mid;

            int[] L = new int[ln];
            int[] R = new int[rn];

            System.arraycopy(nums, left, L, 0, ln);
            System.arraycopy(nums, mid + 1, R, 0, rn);

            int i = 0, j = 0;
            for (int k = left; k <= right; k++) {
                if (j >= rn || (i < ln && L[i] <= R[j]))
                    nums[k] = L[i++];
                else
                    nums[k] = R[j++];
            }
        }

        private int bruteForce(int[] nums) {
            int pairs = 0;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > 2L * nums[i]) pairs++;
                }
            }
            return pairs;
        }

    }
}
