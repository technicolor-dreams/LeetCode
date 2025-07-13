package io.github.technicolordreams.question.of.the.day.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/longest-harmonious-subsequence/">594. Longest Harmonious Subsequence</a></h1>
 * <h2>2025-06-30</h2>
 * <h3>Easy</h3>
 */
public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        LongestHarmoniousSubsequence a = new LongestHarmoniousSubsequence();
        System.out.println(a.solution(new int[]{1, 1, 1, 1}));
        System.out.println(a.solution(new int[]{1, 2, 3, 4}));
        System.out.println(a.solution(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }

    public int solution(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.putIfAbsent(num, 0);
            count.computeIfPresent(num, (k, v) -> v + 1);
        }

        int res = 0;
        for (int num : nums) {
            if (count.getOrDefault(num + 1, 0) == 0) {
                continue;
            }

            res = Math.max(res, count.get(num) + count.getOrDefault(num + 1, 0));
        }

        return res;
    }
}
