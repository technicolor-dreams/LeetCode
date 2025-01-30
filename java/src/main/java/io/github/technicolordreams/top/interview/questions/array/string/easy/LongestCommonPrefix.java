package io.github.technicolordreams.top.interview.questions.array.string.easy;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/longest-common-prefix/">14. Longest Common Prefix</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-30</h3>
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] words = {"flower", "flow", "flight"};
        longestCommonPrefix.solution(words);
    }

    public String solution(String[] strs) {
        StringBuilder res = new StringBuilder();
        String first = strs[0];
        boolean isCommonPrefix = true;
        int i = 0;
        while (isCommonPrefix) {
            if (i > first.length() - 1) {
                return res.toString();
            }

            char cur = strs[0].charAt(i);
            int finalI = i;
            isCommonPrefix = Arrays.stream(strs).allMatch(s -> finalI < s.length() && s.charAt(finalI) == cur);
            if (isCommonPrefix) {
                res.append(cur);
            }

            i += 1;
        }

        return res.toString();
    }
}
