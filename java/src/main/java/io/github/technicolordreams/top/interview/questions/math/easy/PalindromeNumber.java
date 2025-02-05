package io.github.technicolordreams.top.interview.questions.math.easy;

/**
 * <h1><a href="https://leetcode.com/problems/palindrome-number/description/">9. Palindrome Number</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-02-05</h3>
 */
public class PalindromeNumber {
    public boolean solution(int x) {
        if (x < 0) {
            return false;
        }

        return String.valueOf(x).contentEquals(new StringBuilder(String.valueOf(x)).reverse());
    }
}
