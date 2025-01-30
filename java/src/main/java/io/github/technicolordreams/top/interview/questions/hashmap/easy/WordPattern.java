package io.github.technicolordreams.top.interview.questions.hashmap.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/word-pattern/description/">290. Word Pattern</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-25</h3>
 */
public class WordPattern {
    public boolean solution(String pattern, String s) {
        String[] split = s.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }

        Map<Character, String> charMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i += 1) {
            char curPattern = pattern.charAt(i);
            String curS = split[i];
            if (charMap.containsKey(curPattern)) {
                if (!charMap.get(curPattern).equals(curS)) {
                    return false;
                }
            } else {
                charMap.put(curPattern, curS);
            }
        }

        Map<String, Character> sMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i += 1) {
            char curPattern = pattern.charAt(i);
            String curS = split[i];
            if (sMap.containsKey(curS)) {
                if (sMap.get(curS) != curPattern) {
                    return false;
                }
            } else {
                sMap.put(curS, curPattern);
            }
        }

        return true;
    }
}
