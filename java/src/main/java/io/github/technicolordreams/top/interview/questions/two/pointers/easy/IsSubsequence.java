package io.github.technicolordreams.top.interview.questions.two.pointers.easy;

/**
 * <h1><a href="https://leetcode.com/problems/is-subsequence/description/">392. Is Subsequence</a></h1>
 * <h2>Easy</h2>
 * <h3>2024-01-23</h3>
 */
public class IsSubsequence {
    public static boolean solution(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }

        if (s.isEmpty()) {
            return true;
        }


        int i = 0;
        for (int j = 0; j < t.length(); j += 1) {
            if (t.charAt(j) == s.charAt(i)) {
                i += 1;
            }

            if (i == s.length()) {
                return true;
            }
        }

        return false;
    }
}
