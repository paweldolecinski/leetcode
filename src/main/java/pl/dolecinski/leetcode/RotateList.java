package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, new int[]{4, 5, 1, 2, 3}),
            Arguments.of(new int[]{0, 1, 2}, 4, new int[]{2, 0, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testCyclesMethod(int[] nums, int k, int[] expected) {
        Solution.ListNode head = new Solution.ListNode(nums[0]);
        Solution.ListNode prev = head;
        for (int i = 1; i < nums.length; i++) {
            Solution.ListNode node = new Solution.ListNode(nums[i]);
            prev.next = node;
            prev = node;
        }
        Solution.ListNode newHead = new Solution().rotateRight(head, k);

        int[] result = new int[expected.length];
        Solution.ListNode curr = newHead;
        int i = 0;
        while (curr != null) {
            result[i++] = curr.val;
            curr = curr.next;
        }
        assertArrayEquals(expected, result);
    }

    static class Solution {

        public static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) return head;
            int size = 0;
            ListNode iter = head;
            while (iter != null) {
                iter = iter.next;
                size++;
            }
            k = k % size;
            if (k == 0) return head;

            iter = head;
            for (int i = 0; i < k; i++) {
                iter = iter.next;
            }
            ListNode tail = head;     // the actual tail of new listnode
            while (iter.next != null) {
                tail = tail.next;
                iter = iter.next;
            }
            ListNode newHead = tail.next; // the actual new head of listnode
            tail.next = null;         // set the tail
            iter.next = head;        // link the previous tail to the previous head
            return newHead;
        }

    }

}
