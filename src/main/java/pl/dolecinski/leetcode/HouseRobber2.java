package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/house-robber-ii/
 */
public class HouseRobber2 {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 1}, 4)
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
            if (nums.length == 2) return Math.max(nums[0], nums[1]);

            int startFromFirst = maxRobbed(nums, 0, nums.length - 1);
            int startFromSecond = maxRobbed(nums, 1, nums.length);

            return Math.max(startFromFirst, startFromSecond);
        }

        private int maxRobbed(int[] nums, int start, int end) {
            int[] dp = new int[nums.length];
            dp[start] = nums[start];
            dp[start + 1] = Math.max(nums[start], nums[start + 1]);

            for (int i = start + 2; i < end; i++)
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

            return dp[end - 1];
        }
    }

}
