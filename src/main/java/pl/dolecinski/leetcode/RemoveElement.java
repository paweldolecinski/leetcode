package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}),
            Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 1, 3, 0, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] nums, int val, int[] expected) {
        int len = new Solution().removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }

    static class Solution {

        public int removeElement(int[] nums, int val) {
            int valPos = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val)
                    nums[valPos++] = nums[i];
            }
            return valPos;
        }

    }

}
