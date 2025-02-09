package io.github.technicolordreams.question.of.the.day.medium;

import java.util.*;

/**
 * <h1><a href="https://leetcode.com/problems/count-number-of-bad-pairs/">2364. Count Number of Bad Pairs</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-09</h3>
 */
public class CountNumberOfBadPairs {
    public static void main(String[] args) {
        CountNumberOfBadPairs a = new CountNumberOfBadPairs();
        System.out.println(a.solution(new int[]{4,1,3,3}));
        System.out.println(a.solution(new int[]{1,2,3,4,5}));
    }

    public long solution(int[] nums) {
        Map<Integer, Integer> mem = new HashMap<>();
        for (int i = 0; i < nums.length; i += 1) {
            mem.putIfAbsent(i - nums[i], 0);
            mem.computeIfPresent(i - nums[i], (k, v) -> v + 1);
        }

        long invalidCount =
                mem.values().stream()
                        .map(CountNumberOfBadPairs::combinations)
                        .mapToLong(Long::longValue)
                        .sum();

        return combinations(nums.length) - invalidCount;
    }

    // Method to calculate combinations C(n, 2) without factorials
    private static long combinations(int n) {
        if (n < 2) {
            return 0; // No valid pairs if n < 2
        }
        return (long) n * (n - 1) / 2;
    }
}
