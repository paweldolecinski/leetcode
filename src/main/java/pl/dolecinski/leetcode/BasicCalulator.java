package pl.dolecinski.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/basic-calculator-ii
 */
public class BasicCalulator {

    public static void main(String[] args) {
        String arg = " 3+5 / 2 ";
        int result = new Solution().calculate(arg);
        System.out.println(result);
    }

    static class Solution {

        public int calculate(String string) {
            Deque<Integer> stack = new LinkedList<>();
            string = string.replaceAll("\\s", "");

            int i = 0;
            while (i < string.length()) {

                if (Character.isDigit(string.charAt(i))) {
                    i = consumeAndStackNumber(string, i, stack);
                } else if (string.charAt(i) == '*') {
                    i = consumeAndStackNumber(string, ++i, stack);
                    stack.addFirst(stack.removeFirst() * stack.removeFirst());
                } else if (string.charAt(i) == '/') {
                    i = consumeAndStackNumber(string, ++i, stack);
                    int divider = stack.removeFirst();
                    stack.addFirst(stack.removeFirst() / divider);
                } else if (string.charAt(i) == '-') {
                    i = consumeAndStackNumber(string, ++i, stack);
                    stack.addFirst(-stack.removeFirst());
                } else i++;
            }

            return sumUp(stack);
        }

        private int consumeAndStackNumber(String string, int i, Deque<Integer> stack) {
            int number = 0;
            while (i < string.length() && Character.isDigit(string.charAt(i))) {
                number = number * 10 + (string.charAt(i) - '0');
                i++;
            }
            stack.addFirst(number);
            return i;
        }

        private int sumUp(Deque<Integer> deque) {
            int result = 0;
            while (!deque.isEmpty()) {
                result += deque.removeFirst();
            }
            return result;
        }
    }
}
