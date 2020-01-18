package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/beautiful-array/
 * Divide and Conquer
 * <p>
 * If we make k's left part are all odd(or even) numbers and right part are all even(or odd) numbers,
 * since A[k] * 2 will definitely be an even number and A[i] + A[j] will always be an odd number.
 * Therefore, they can't be equal.
 */
public class BeautifulArray {

    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(4, new int[]{2, 1, 4, 3}),
            Arguments.of(5, new int[]{3, 1, 2, 5, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int input, int[] expected) {
        int[] ints = new Solution().beautifulArray(input);
        System.out.println(Arrays.toString(ints));
    }

    static class Solution {

        Map<Integer, int[]> memo = new HashMap<>();

        public int[] beautifulArray(int N) {
            if (memo.containsKey(N))
                return memo.get(N);

            int[] ans = new int[N];
            if (N == 1) {
                ans[0] = 1;
            } else {
                int t = 0;
                for (int x : beautifulArray((N + 1) / 2))  // odds
                    ans[t++] = 2 * x - 1;
                for (int x : beautifulArray(N / 2))  // evens
                    ans[t++] = 2 * x;
            }
            memo.put(N, ans);
            return ans;
        }

    }
}
