package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{3, 0, 1}, 2),
            Arguments.of(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8)

        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] nums, int expected) {
        assertEquals(expected, new Solution().missingNumberGauss(nums));
    }

    static class Solution {

        public int missingNumberGauss(int[] nums) {
            int expectedSum = nums.length * (nums.length + 1) / 2;
            int actualSum = 0;
            for (int num : nums) actualSum += num;
            return expectedSum - actualSum;
        }

        public int missingNumberHashSet(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) numSet.add(num);

            int expectedNumCount = nums.length + 1;
            for (int number = 0; number < expectedNumCount; number++) {
                if (!numSet.contains(number)) {
                    return number;
                }
            }
            return -1;
        }
    }

}
