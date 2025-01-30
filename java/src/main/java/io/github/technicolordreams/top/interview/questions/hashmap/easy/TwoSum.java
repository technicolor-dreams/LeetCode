package io.github.technicolordreams.top.interview.questions.hashmap.easy;

import java.util.*;

/**
 * <h1><a href="https://leetcode.com/problems/two-sum/description/">1. Two Sum</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-26</h3>
 */
public class TwoSum {
    public int[] solution(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i += 1) {
            int cur = nums[i];
            int finalI = i;
            map.putIfAbsent(cur, new ArrayList<>());
            map.computeIfPresent(cur, (k, v) -> {
                v.add(finalI);
                return v;
            });
        }

        for (int key : map.keySet()) {
            int pair = target - key;
            if (key == pair && map.get(key).size() > 1) {
                List<Integer> list = map.get(key);
                return new int[]{list.getFirst(), list.get(1)};
            }

            if (key != pair && map.containsKey(pair)) {
                return new int[]{map.get(key).getFirst(), map.get(pair).getFirst()};
            }
        }

        return new int[]{};
    }
}
