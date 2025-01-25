package io.github.technicolordreams.top.interview.questions.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/isomorphic-strings/description/">205. Isomorphic Strings</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-25</h3>
 */
public class IsomorphicStrings {
    public boolean solution(String s, String t) {
        return helper(s, t) && helper(t, s);
    }

    private boolean helper(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i += 1) {
            char curS = s.charAt(i);
            char curT = t.charAt(i);
            if (map.containsKey(curS)) {
                if (map.get(curS) != curT) {
                    return false;
                }
            } else {
                map.put(curS, curT);
            }
        }

        return true;
    }
}
