package io.github.technicolordreams.top.interview.questions.array.string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/majority-element/description/">169. Majority Element</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-29</h3>
 */
public class MajorityElement {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.putIfAbsent(n, 0);
            map.computeIfPresent(n, (k, v) -> v + 1);
        }

        int majorityCount = Math.floorDiv(nums.length, 2);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majorityCount) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
