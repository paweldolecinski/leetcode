package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotatedSortedArray {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] nums, int target, int expected) {
        assertEquals(expected, new Solution().search(nums, target));
    }

    static class Solution {

        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = nums[mid];

                if (midVal == target) return mid;

                if (midVal <= nums[high]) {//right half is sorted
                    if (midVal < target && target <= nums[high]) low = mid + 1;
                    else high = mid - 1;
                } else {
                    if (midVal > target && target >= nums[low]) high = mid -1;
                    else low = mid + 1;
                }
            }

            return -1;
        }
    }

}
