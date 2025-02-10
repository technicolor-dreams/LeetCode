package io.github.technicolordreams.question.of.the.day.easy;

/**
 * <h1><a href="https://leetcode.com/problems/clear-digits/description/">3174. Clear Digits</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-02-10</h3>
 */
public class ClearDigits {
    public static void main(String[] args) {
        ClearDigits a = new ClearDigits();
        System.out.println(a.solution("abc"));
        System.out.println(a.solution("cb34"));
    }

    public String solution(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                res.deleteCharAt(res.length() - 1);
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}
