package pl.dolecinski.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 */
public class IntervalListIntersections {

    public static void main(String[] args) {

        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};

        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        int[][] result = new Solution().intervalIntersection(A, B);

        System.out.println(Arrays.deepToString(result));
    }

    static class Solution {

        public int[][] intervalIntersection(int[][] A, int[][] B) {

            ArrayList<int[]> lists = new ArrayList<>();

            int ai = 0;
            int bi = 0;
            while (ai < A.length && bi < B.length) {

                int ax = A[ai][0];
                int ay = A[ai][1];
                int bx = B[bi][0];
                int by = B[bi][1];

                int lo = Math.max(ax, bx);
                int hi = Math.min(ay, by);

                if (lo <= hi) {
                    lists.add(new int[]{lo, hi});
                }

                if (ay < by) {
                    ai++;
                } else {
                    bi++;
                }


            }


            return lists.toArray(new int[0][]);
        }


    }
}
