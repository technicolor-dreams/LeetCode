package io.github.technicolordreams.top.interview.questions.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/valid-anagram/description/">242. Valid Anagram</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-25</h3>
 */
public class ValidAnagram {
    public boolean solution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.computeIfPresent(c, (k, v) -> v + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            if (map.get(c) == 0) {
                return false;
            }

            map.computeIfPresent(c, (k, v) -> v - 1);
        }

        return map.values().stream().filter(i -> i > 0).findFirst().isEmpty();
    }
}
