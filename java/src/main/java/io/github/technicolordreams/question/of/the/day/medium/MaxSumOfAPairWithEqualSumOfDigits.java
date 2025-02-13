package io.github.technicolordreams.question.of.the.day.medium;

import java.util.*;

/**
 * <h1><a href="https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/">2342. Max Sum of a Pair With Equal Sum of Digits</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-12</h3>
 */
public class MaxSumOfAPairWithEqualSumOfDigits {
    public static void main(String[] args) {
        MaxSumOfAPairWithEqualSumOfDigits a = new MaxSumOfAPairWithEqualSumOfDigits();
//        System.out.println(a.solution(new int[]{18,43,36,13,7}));
//        System.out.println(a.solution(new int[]{10,12,19,14}));
//        System.out.println(a.solution(new int[]{229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401}));
        System.out.println(a.solution(new int[]{383, 77, 97, 261, 102, 344, 150, 130, 55, 337, 401, 498, 21, 5}));
    }

    public int solution(int[] nums) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i += 1) {
            int cur = nums[i];
            int curDigitSum =
                    Arrays.stream(String.valueOf(cur).split(""))
                            .mapToInt(Integer::valueOf)
                            .sum();

            map.putIfAbsent(curDigitSum, new HashSet<>());
            int finalI = i;
            map.computeIfPresent(curDigitSum, (k, v) -> {
                v.add(finalI);
                return v;
            });
        }

        return map
                .values()
                .stream()
                .filter(s -> s.size() > 1)
                .map(s -> s
                        .stream()
                        .map(i -> nums[i])
                        .sorted(Comparator.reverseOrder())
                        .limit(2)
                        .mapToInt(Integer::intValue)
                        .sum())
                .mapToInt(Integer::intValue)
                .max()
                .orElse(-1);
    }
}
