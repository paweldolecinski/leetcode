package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 1, 2}, new int[]{1, 2}),
            Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] nums, int[] expected) {
        int len = new Solution().removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }

    static class Solution {

        public int removeDuplicates(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            int duplicatePos = 1;

            int currentValue = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != currentValue) {
                    nums[duplicatePos++] = nums[i];
                    currentValue = nums[i];
                }
            }
            return duplicatePos;
        }

    }

}
