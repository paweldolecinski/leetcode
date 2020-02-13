package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArray2 {
    private static Stream<Arguments> testCases() {
        return Stream.of(
//            Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, new int[]{1, 1, 2, 2, 3}),
//            Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4}),
            Arguments.of(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 3, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] nums, int[] expected) {
        System.out.println(Arrays.toString(nums));
        int len = new Solution().removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(expected));
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
            boolean twice = false;
            int currentValue = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != currentValue) {
                    nums[duplicatePos++] = nums[i];
                    currentValue = nums[i];
                    twice = false;
                } else if (!twice) {
                    nums[duplicatePos++] = nums[i];
                    twice = true;
                }
            }
            return duplicatePos;
        }

    }

}
