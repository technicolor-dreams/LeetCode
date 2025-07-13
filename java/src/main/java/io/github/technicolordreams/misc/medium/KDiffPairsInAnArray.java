package io.github.technicolordreams.misc.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h1><a href="https://leetcode.com/problems/k-diff-pairs-in-an-array/">532. K-diff Pairs in an Array</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-07-01</h3>
 */
public class KDiffPairsInAnArray {
    public static void main(String[] args) {
        KDiffPairsInAnArray a = new KDiffPairsInAnArray();
        System.out.println(a.solution(new int[]{3,1,4,1,5}, 2));
        System.out.println(a.solution(new int[]{1,2,3,4,5}, 1));
        System.out.println(a.solution(new int[]{1,3,1,5,4}, 0));
    }

    public int solution(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.putIfAbsent(num, 0);
            count.computeIfPresent(num, (key, val) -> val + 1);
        }

        Set<String> pairs = new HashSet<>();
        for (int num : nums) {
            if (k == 0) {
                if (count.get(num) == 1) {
                    continue;
                } else {
                    pairs.add(String.format("%d%d", num, num));
                    continue;
                }
            }

            int potential1 = num + k;
            if (count.getOrDefault(potential1, 0) > 0) {
                pairs.add(Stream.of(num, potential1).sorted().map(String::valueOf).collect(Collectors.joining()));
            }

            int potential2 = num - k;
            if (count.getOrDefault(potential2, 0) > 0) {
                pairs.add(Stream.of(num, potential2).sorted().map(String::valueOf).collect(Collectors.joining()));
            }
        }

        return pairs.size();
    }
}
