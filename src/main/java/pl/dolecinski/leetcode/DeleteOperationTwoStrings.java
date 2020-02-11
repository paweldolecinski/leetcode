package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 */
public class DeleteOperationTwoStrings {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of("sea", "eat", 2),
            Arguments.of("delete", "leet", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(String s1, String s2, int expected) {
        assertEquals(expected, new Solution().minDistance(s1, s2));
    }

    static class Solution {

        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];

            for (int i = 1; i <= word1.length(); i++) dp[i][0] = i;
            for (int j = 1; j <= word2.length(); j++) dp[0][j] = j;

            for (int i = 1; i <= word1.length(); i++)
                for (int j = 1; j <= word2.length(); j++)
                    if (word1.charAt(i - 1) == word2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);

            return dp[word1.length()][word2.length()];
        }

    }

}
