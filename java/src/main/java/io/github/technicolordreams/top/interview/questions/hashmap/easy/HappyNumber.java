package io.github.technicolordreams.top.interview.questions.hashmap.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1><a href="https://leetcode.com/problems/happy-number/description/">202. Happy Number</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-26</h3>
 */
public class HappyNumber {
    public boolean solution(int n) {
        Set<Integer> seen = new HashSet<>();
        int cur = n;
        while (cur != 1) {
            if (seen.contains(cur)) {
                return false;
            }

            seen.add(cur);
            cur = (int) Arrays.stream(String.valueOf(cur).split(""))
                    .mapToInt(Integer::valueOf)
                    .mapToDouble(i -> Math.pow(i, 2))
                    .sum();
        }

        return true;
    }
}
