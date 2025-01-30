package io.github.technicolordreams.top.interview.questions.array.string.easy;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/length-of-last-word/description/">58. Length of Last Word</a></h1>
 * <h2>Easy</h2>
 * <h3>2024-01-30</h3>
 */
public class LengthOfLastWord {
    public int solution(String s) {
        return Arrays.stream(s.split(" "))
                .map(String::strip)
                .toList()
                .getLast()
                .length();
    }
}
