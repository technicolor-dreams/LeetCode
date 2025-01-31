package io.github.technicolordreams.top.interview.questions.hashmap.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <h1><a href="https://leetcode.com/problems/group-anagrams/description/">49. Group Anagrams</a></h1>
 * <h2>Medium</h2>
 * <h3>2024-01-31</h3>
 */
public class GroupAnagrams {
    public List<List<String>> solution(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sorted = s
                    .chars()
                    .sorted()
                    .mapToObj(c -> (char) c)
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            map.putIfAbsent(sorted, new ArrayList<>());
            map.computeIfPresent(sorted, (k, v) -> {
                v.add(s);
                return v;
            });
        }

        return map.values().stream().toList();
    }
}
