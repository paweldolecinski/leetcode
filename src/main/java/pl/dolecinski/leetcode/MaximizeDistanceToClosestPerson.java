package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 */
public class MaximizeDistanceToClosestPerson {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 0, 0, 0, 1, 0, 1}, 2),
            Arguments.of(new int[]{1, 0, 0, 0}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] nums, int expected) {
        int ans = new Solution().maxDistToClosest(nums);
        assertEquals(expected, ans);
    }

    static class Solution {

        public int maxDistToClosest(int[] seats) {
            int N = seats.length;
            int prev = -1, next = 0;
            int ans = 0;

            for (int i = 0; i < N; i++) {
                if (seats[i] == 1) prev = i;
                else {
                    while (next < N && seats[next] == 0 || next < i) next++;

                    int leftDist = prev == -1 ? N : i - prev;
                    int rightDist = next == N ? N : next - i;
                    ans = Math.max(ans, Math.min(leftDist, rightDist));
                }
            }
            return ans;
        }

    }

}
