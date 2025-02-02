package io.github.technicolordreams.top.interview.questions.hashmap.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <h1><a href="https://leetcode.com/problems/longest-consecutive-sequence/description/">128. Longest Consecutive Sequence</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-02</h3>
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
//        System.out.println(longestConsecutiveSequence.solution(new int[]{100, 4, 200, 1, 3, 2}));
//        System.out.println(longestConsecutiveSequence.solution(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutiveSequence.solution(new int[]{9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7}));
    }

    public int solution(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if (!hashSet.contains(num)) {
                continue;
            }

            hashSet.remove(num);

            int i = 1;
            int sum = 1;
            while (hashSet.contains(num - i)) {
                if (hashSet.contains(num - i)) {
                    sum += 1;
                    hashSet.remove(num - i);
                }

                i += 1;
            }

            i = 1;
            while (hashSet.contains(num + i)) {
                if (hashSet.contains(num + i)) {
                    sum += 1;
                    hashSet.remove(num + i);
                }

                i += 1;
            }

            res = Math.max(res, sum);
        }

        return res;
    }
}
