package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <h1><a href="https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/description/">2099. Find Subsequence of Length K With the Largest Sum</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-06-28</h3>
 */
public class FindSubsequenceOfLengthKWithTheLargestSum {

    public static void main(String[] args) {
        FindSubsequenceOfLengthKWithTheLargestSum a = new FindSubsequenceOfLengthKWithTheLargestSum();
        assert Arrays.equals(a.solution(new int[]{2, 1, 3, 3}, 2), new int[]{3, 3});
        assert Arrays.equals(a.solution(new int[]{-1, -2, 3, 4}, 3), new int[]{-1, 3, 4});
        assert Arrays.equals(a.solution(new int[]{3, 4, 3, 3}, 2), new int[]{3, 4});
    }

    public int[] solution(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueueVal =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (int i = 0; i < nums.length; i += 1) {
            int cur = nums[i];
            if (priorityQueueVal.size() < k) {
                priorityQueueVal.add(Map.entry(i, cur));
            } else {
                Map.Entry<Integer, Integer> curMin = priorityQueueVal.poll();
                if (curMin.getValue() < cur) {
                    priorityQueueVal.add(Map.entry(i, cur));
                } else {
                    priorityQueueVal.add(curMin);

                }
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueueKey =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));
        while (!priorityQueueVal.isEmpty()) {
            priorityQueueKey.add(priorityQueueVal.poll());
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i += 1) {
            res[i] = priorityQueueKey.poll().getValue();
        }

        return res;
    }
}
