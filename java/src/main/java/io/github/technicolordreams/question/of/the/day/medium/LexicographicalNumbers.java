package io.github.technicolordreams.question.of.the.day.medium;

import java.util.List;
import java.util.TreeSet;

/**
 * <h1><a href="https://leetcode.com/problems/lexicographical-numbers/">386. Lexicographical Numbers</a></h1>
 * <h2>Medium</h2>
 * <h3>2025/06/08</h3>
 */
public class LexicographicalNumbers {
    public List<Integer> solution(int n) {
        TreeSet<String> range = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            range.add(String.valueOf(i));
        }

        return range.stream().map(Integer::parseInt).toList();
    }
}
