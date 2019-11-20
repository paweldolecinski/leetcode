package pl.dolecinski.leetcode;

import java.util.StringJoiner;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWords {

    public static void main(String[] args) {
        String arg = "  hello world!  ";
        String result = new Solution().reverseWords(arg);
        System.out.print(result);
    }

    static class Solution {
        public String reverseWords(String s) {
            String[] words = s.split("\\s");

            StringJoiner builder = new StringJoiner(" ");
            for (int i = words.length - 1; i >= 0; i--) {
                if (!words[i].isBlank())
                    builder.add(words[i]);
            }
            return builder.toString();
        }

    }
}
