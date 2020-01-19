package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInArray {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{3,2,1,5,6,4}, 2, 5),
            Arguments.of(new int[]{3,2,3,1,2,4,5,5,6}, 4, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] nums, int k, int expected) {
        assertEquals(expected, new Solution().findKthLargest(nums, k));
    }

    static class Solution {

        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for (int num : nums) {
                minHeap.add(num);
            }

            for (int i = 0; i < nums.length - k; i++) {
                minHeap.poll();
            }

            return minHeap.peek();
        }
    }

}
