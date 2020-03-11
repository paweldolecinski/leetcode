package pl.dolecinski.leetcode;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts/
 */
public class SplitLinkedListInParts {

    static class Solution {

        public static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        public ListNode[] splitListToParts(ListNode root, int k) {

            int listLength = 0;
            ListNode iter = root;
            while (iter != null) {
                iter = iter.next;
                listLength++;
            }

            int bucketLength = listLength / k;
            int extraItems = listLength % k;


            ListNode[] result = new ListNode[k];
            iter = root;
            for (int bucket = 0; bucket < k; bucket++) {
                ListNode head = iter;
                for (int j = 0; j < bucketLength + (bucket < extraItems ? 1 : 0) - 1; j++)
                    if (iter != null) iter = iter.next;

                if(iter != null){
                    ListNode prev = iter;
                    iter = iter.next;
                    prev.next = null;

                }
                result[bucket] = head;
            }

            return result;
        }

    }

}
