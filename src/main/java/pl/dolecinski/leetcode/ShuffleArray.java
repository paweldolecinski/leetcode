package pl.dolecinski.leetcode;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);

        print(solution.shuffle());
        print(solution.reset());
        print(solution.shuffle());
    }

    static class Solution {

        private final Random random = new Random();
        private int[] nums;
        private int[] original;

        public Solution(int[] nums) {
            this.original = nums.clone();
            this.nums = nums;
        }

        public int[] reset() {
            nums = original;
            original = original.clone();
            return nums;
        }

        public int[] shuffle() {
            nums = reset();

            for (int i = 0; i < nums.length; i++) {
                swap(i, randomIndice(i, nums.length));
            }

            return nums;
        }

        private int randomIndice(int min, int max) {
            return random.nextInt(max - min) + min;
        }

        private void swap(int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }

    private static void print(int[] shuffle) {
        System.out.println(Arrays.toString(shuffle));
    }
}
