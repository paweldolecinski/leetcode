package pl.dolecinski.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/snapshot-array/
 */
public class SnapshotArray {

    static class Solution {

        private int snapId;
        private List<TreeMap<Integer, Integer>> storage;

        public Solution(int length) {
            storage = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                storage.add(new TreeMap<>());
                storage.get(i).put(0, 0);
            }
        }

        public void set(int index, int val) {
            storage.get(index).put(snapId, val);
        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            return storage.get(index).floorEntry(snap_id).getValue();
        }

    }

    public static void main(String[] args) {

        Solution snapshotArr = new Solution(1);

        snapshotArr.set(0, 15);
        snapshotArr.snap();
        snapshotArr.snap();
        snapshotArr.snap();
        int i = snapshotArr.get(0, 2);
        snapshotArr.snap();
        snapshotArr.snap();
        int i1 = snapshotArr.get(0, 0);
        System.out.println(i + " " + i1);
    }
}
