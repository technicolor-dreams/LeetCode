package io.github.technicolordreams.top.interview.questions.array.string.medium;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/reverse-words-in-a-string/description/">151. Reverse Words in a String</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-01-30</h3>
 */
public class ReverseWordsInAString {
    public String solution(String s) {
        return String.join(" ",
                Arrays.stream(s.split(" "))
                        .filter(str -> !str.isBlank())
                        .map(String::strip)
                        .toList()
                        .reversed());
    }
}
