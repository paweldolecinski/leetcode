package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumRotatedSortedArray {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{3, 4, 5, 1, 2}, 1),
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0),
            Arguments.of(new int[]{3, 1, 2}, 1)

        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] nums, int expected) {
        assertEquals(expected, new Solution().findMin(nums));
    }

    static class Solution {

        public int findMin(int[] nums) {
            if (nums.length == 1) return nums[0];
            if (nums[nums.length - 1] > nums[0]) return nums[0];

            int low = 0;
            int high = nums.length - 1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] < nums[high]) high = mid;
                else low = mid + 1;
            }
            return -1;
        }
    }

}
