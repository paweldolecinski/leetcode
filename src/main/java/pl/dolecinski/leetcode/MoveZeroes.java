package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] nums, int[] expected) {
        new Solution().moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    static class Solution {

        public void moveZeroes(int[] nums) {
            int zeroPos = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[zeroPos++] = nums[i];
                }
            }
            for (int i = zeroPos; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

    }

}
