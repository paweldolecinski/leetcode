package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class HouseRobber {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 1}, 4),
            Arguments.of(new int[]{2, 7, 9, 3, 1}, 12),
            Arguments.of(new int[]{}, 0),
            Arguments.of(new int[]{3}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] nums, int expected) {
        assertEquals(expected, new Solution().rob(nums));
    }

    static class Solution {

        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];

            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++)
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

            return Math.max(dp[nums.length - 2], dp[nums.length - 1]);
        }
    }

}
