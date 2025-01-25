package io.github.technicolordreams.top.interview.questions.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/ransom-note/description/">383. Ransom Note</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-25</h3>
 */
public class RansomNote {
    public boolean solution(String ransomNote, String magazine) {
        Map<Character, Integer> hashmap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            hashmap.putIfAbsent(c, 0);
            hashmap.computeIfPresent(c, (k, v) -> v + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!hashmap.containsKey(c)) {
                return false;
            }

            if (hashmap.get(c) == 0) {
                return false;
            }

            hashmap.computeIfPresent(c, (k, v) -> v - 1);
        }

        return true;
    }
}
