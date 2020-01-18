package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/burst-balloons/
 */
public class BurstBalloons {

    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{3, 1, 5, 8}, 167)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] input, int expected) {
        assertEquals(expected, new BurstBalloons.Solution().maxCoins(input));
    }

    static class Solution {

        public int maxCoins(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];

            return burstAll(nums);
        }

        private int burstAll(int[] nums) {
            int length = nums.length;
            int[][] memo = new int[length][length];

            for (int n = 0; n < length; n++) {
                for (int left = 0; left + n < length; left++) {
                    int right = left + n;
                    for (int k = left; k <= right; k++)

                        memo[left][right] = Math.max(
                            memo[left][right],
                            ((k - 1 >= left) ? memo[left][k - 1] : 0)
                                + burstBalloon(nums, left - 1, k, right + 1)
                                + ((k + 1 <= right) ? memo[k + 1][right] : 0));
                }
            }

            return memo[0][length - 1];
        }

        private int burstBalloon(int[] nums, int left, int i, int right) {
            return (left < 0 ? 1 : nums[left]) * nums[i] * (right >= nums.length ? 1 : nums[right]);
        }

    }
}
