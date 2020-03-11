package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
            Arguments.of(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testCyclesMethod(int[] nums, int k, int[] expected) {
        new Solution().rotateByCycles(nums, k);
        assertArrayEquals(expected, nums);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testReverseMethod(int[] nums, int k, int[] expected) {
        new Solution().rotateByReverse(nums, k);
        assertArrayEquals(expected, nums);
    }

    static class Solution {

        public void rotateByCycles(int[] nums, int k) {
            k %= nums.length;
            int count = 0;
            for (int start = 0; count < nums.length; start++) {
                int nextIdx = start;
                int nextValue = nums[start];
                do {
                    nextIdx = (nextIdx + k) % nums.length;
                    int tmp = nums[nextIdx];
                    nums[nextIdx] = nextValue;
                    nextValue = tmp;
                    count++;
                } while (nextIdx != start);
            }
        }

        public void rotateByReverse(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int tmp = nums[end];
                nums[end] = nums[start];
                nums[start] = tmp;
                start++;
                end--;
            }
        }
    }

}
