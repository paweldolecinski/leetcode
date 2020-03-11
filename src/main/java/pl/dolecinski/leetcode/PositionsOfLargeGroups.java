package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/positions-of-large-groups/
 */
public class PositionsOfLargeGroups {

    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of("abbxxxxzzy", new int[][]{{3, 6}}),
            Arguments.of("aaa", new int[][]{{0, 2}}),
            Arguments.of("abc", new int[][]{}),
            Arguments.of("abcdddeeeeaabbbcd", new int[][]{{3, 5}, {6, 9}, {12, 14}})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(String input, int[][] expected) {
        List<List<Integer>> lists = new Solution().largeGroupPositions(input);

        int[][] res = lists.stream()
            .map(l -> l.stream().mapToInt(i -> i).toArray())
            .toArray(int[][]::new);

        assertArrayEquals(expected, res);
    }

    static class Solution {
        public List<List<Integer>> largeGroupPositions(String S) {
            if (S.length() < 3) return Collections.emptyList();

            List<List<Integer>> result = new ArrayList<>();
            int groupStart = 0;

            for (int i = 0; i < S.length(); i++) {
                if (i == S.length() - 1 || S.charAt(i) != S.charAt(i + 1)) {
                    if (i - groupStart + 1 >= 3) result.add(Arrays.asList(groupStart, i));
                    groupStart = i + 1;
                }
            }
            return result;
        }

    }
}
