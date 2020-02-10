package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 */
public class MinimumASCIIDeleteSum {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of("sea", "eat", 231),
            Arguments.of("delete", "leet", 403)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(String s1, String s2, int expected) {
        assertEquals(expected, new Solution().minimumDeleteSum(s1, s2));
    }

    static class Solution {

        public int minimumDeleteSum(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();
            int[][] asciiDistance = new int[m + 1][n + 1];

            char[] s1chars = s1.toCharArray();
            char[] s2chars = s2.toCharArray();
            for (int i = 1; i <= m; i++) asciiDistance[i][0] = asciiDistance[i - 1][0] + s1chars[i - 1];
            for (int j = 1; j <= n; j++) asciiDistance[0][j] = asciiDistance[0][j - 1] + s2chars[j - 1];

            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++)
                    if (s1chars[i - 1] == s2chars[j - 1])
                        asciiDistance[i][j] = asciiDistance[i - 1][j - 1];
                    else
                        asciiDistance[i][j] = Math.min(asciiDistance[i - 1][j] + s1chars[i - 1], asciiDistance[i][j - 1] + s2chars[j - 1]);

            return asciiDistance[m][n];
        }

    }

}
