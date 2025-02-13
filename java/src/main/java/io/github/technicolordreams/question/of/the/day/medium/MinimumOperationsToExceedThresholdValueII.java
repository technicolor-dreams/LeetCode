package io.github.technicolordreams.question.of.the.day.medium;

import java.util.PriorityQueue;

/**
 * <h1><a href="https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/">3066. Minimum Operations to Exceed Threshold Value II</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-13</h3>
 */
public class MinimumOperationsToExceedThresholdValueII {
    public static void main(String[] args) {
        MinimumOperationsToExceedThresholdValueII a = new MinimumOperationsToExceedThresholdValueII();
//        System.out.println(a.solution(new int[]{2,11,10,1,3}, 10));
//        System.out.println(a.solution(new int[]{1,1,2,4,9}, 20));
        System.out.println(a.solution(new int[]{999999999,999999999,999999999}, 1000000000));
    }
    public int solution(int[] nums, int k) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add((long) num);
        }

        int res = 0;
        while (priorityQueue.peek() < k) {
            long x = priorityQueue.poll();
            long y = priorityQueue.poll();
            priorityQueue.add(Math.min(x, y) * 2 + Math.max(x, y));
            res += 1;
        }

        return res;
    }
}
