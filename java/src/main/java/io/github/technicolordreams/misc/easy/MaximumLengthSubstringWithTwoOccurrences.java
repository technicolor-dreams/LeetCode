package io.github.technicolordreams.misc.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/">3090. Maximum Length Substring With Two Occurrences</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-06-28</h3>
 */
public class MaximumLengthSubstringWithTwoOccurrences {

    public static void main(String[] args) {
        MaximumLengthSubstringWithTwoOccurrences a = new MaximumLengthSubstringWithTwoOccurrences();
        System.out.println(a.solution("bcbbbcba"));
        System.out.println(a.solution("aaaa"));
    }

    public int solution(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int left = 0, res = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0) + 1);

            // If any character appears more than twice, shrink window from the left
            while (count.get(c) > 2) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
