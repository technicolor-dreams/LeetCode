package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/find-the-original-typed-string-i/">3330. Find the Original Typed String I</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-07-01</h3>
 */
public class FindTheOriginalTypedStringI {
    public static void main(String[] args) {
        FindTheOriginalTypedStringI a = new FindTheOriginalTypedStringI();
        System.out.println(a.solution("abbcccc"));
        System.out.println(a.solution("abcd"));
        System.out.println(a.solution("aaaa"));
    }

    public int solution(String word) {
        int res = 1;
        int curCount = 1;
        for (int i = 0; i < word.length() - 1; i += 1) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                curCount += 1;
            } else {
                res += curCount - 1;
                curCount = 1;
            }
        }

        res += curCount - 1;
        return res;
    }
}
