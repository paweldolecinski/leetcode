package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/circular-array-loop/
 * <p>
 * Detect loop in a directed graph, use DFS graph coloring algorithm.
 */
public class CircularArrayLoop {

    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{2, -1, 1, 2, 2}, true),
            Arguments.of(new int[]{-1, 2}, false),
            Arguments.of(new int[]{-2, 1, -1, -2, -2}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] input, boolean expected) {
        assertEquals(expected, new Solution().circularArrayLoop(input));
    }

    static class Solution {

        public boolean circularArrayLoop(int[] nums) {
            int[] color = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (color[i] == 0 && hasLoop(nums, color, i)) return true;
            }
            return false;
        }

        private boolean hasLoop(int[] nums, int[] color, int i) {
            if (color[i] == 2) return false;

            color[i] = 1;
            int next = (i + nums[i]) % nums.length + nums.length;
            next %= nums.length;
            if (next == i || nums[next] * nums[i] < 0) {
                color[i] = 2;
                return false;
            }
            if (color[next] == 1) {
                color[i] = 2;
                return true;
            }
            if (hasLoop(nums, color, next)) return true;

            color[i] = 2;
            return false;
        }

    }
}
