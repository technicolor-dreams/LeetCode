package io.github.technicolordreams.top.interview.questions.hashmap.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <h1><a href="https://leetcode.com/problems/contains-duplicate-ii/description/">219. Contains Duplicate II</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-26</h3>
 */
public class ContainsDuplicateII {
    public boolean solution(int[] nums, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            int cur = nums[i];
            map.putIfAbsent(cur, new HashSet<>());

            if (map.get(cur).stream().anyMatch(j -> Math.abs(finalI - j) <= k)) {
                return true;
            }

            map.computeIfPresent(cur, (key, v) -> {
                v.add(finalI);
                return v;
            });
        }

        return false;
    }
}
