package pl.dolecinski.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 6, 3, 4, 5, 6}, 6, new int[]{1, 2, 3, 4, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(int[] nums, int val, int[] expected) {
        Solution.ListNode head = new Solution.ListNode(nums[0]);
        Solution.ListNode prev = head;
        for (int i = 1; i < nums.length; i++) {
            Solution.ListNode node = new Solution.ListNode(nums[i]);
            prev.next = node;
            prev = node;
        }
        Solution.ListNode newHead = new Solution().removeElements(head, val);

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

        public ListNode removeElements(ListNode head, int val) {

            ListNode iter = head;
            ListNode newHead = head;
            ListNode prev = null;

            while (iter != null) {
                if (iter.val == val)
                    if (prev == null) newHead = iter.next;
                    else prev.next = iter.next;
                else
                    prev = iter;

                iter = iter.next;
            }
            return newHead;
        }

    }

}
