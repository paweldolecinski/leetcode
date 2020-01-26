package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchRotatedSortedArray2 {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{2, 5, 6, 0, 0, 1, 2}, 0, true),
            Arguments.of(new int[]{2, 5, 6, 0, 0, 1, 2}, 3, false),
            Arguments.of(new int[]{1, 1, 3, 1}, 3, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] nums, int target, boolean expected) {
        assertEquals(expected, new Solution().search(nums, target));
    }

    static class Solution {

        public boolean search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            return binarySearch(nums, target, low, high);
        }

        public boolean binarySearch(int[] nums, int target, int low, int high) {
            if (low > high) return false;
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];

            if (midVal == target) return true;

            if (midVal < nums[high]) {//right half is strictly sorted
                if (midVal < target && target <= nums[high]) return binarySearch(nums, target, mid + 1, high);
                else return binarySearch(nums, target, low, mid - 1);
            } else {
                return binarySearch(nums, target, low, mid - 1)
                    || binarySearch(nums, target, mid + 1, high);
            }
        }
    }

}
