package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}, true),
            Arguments.of(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}, false),
            Arguments.of(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] nums, boolean expected) {
        assertEquals(expected, new Solution().canThreePartsEqualSum(nums));
    }

    static class Solution {

        public boolean canThreePartsEqualSum(int[] A) {

            int total = 0;
            for (int val : A) total += val;
            if (total % 3 != 0) return false;

            int target = total / 3;

            int currentSum = 0;
            int parts = 0;
            for (int val : A) {
                currentSum += val;
                if (currentSum == target) {
                    parts++;
                    currentSum = 0;
                }
            }
            return parts == 3;
        }

    }

}
