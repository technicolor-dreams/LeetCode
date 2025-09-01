package io.github.technicolordreams.question.of.the.day.medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <h1><a href="https://leetcode.com/problems/maximum-average-pass-ratio/description/">1792. Maximum Average Pass Ratio</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-09-01</h3>
 */
public class MaximumAveragePassRatio {
    public static void main(String[] args) {
        MaximumAveragePassRatio a = new MaximumAveragePassRatio();

        int[][] array1 = {{1, 2}, {3, 5}, {2, 2}};
        int[][] array2 = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};

        System.out.println(a.solution(array1, 2));
        System.out.println(a.solution(array2, 4));
    }

    public double solution(int[][] classes, int extraStudents) {
        PriorityQueue<Map.Entry<Double, Double>> classesPrioritizePassRateIncrease =
                new PriorityQueue<>(
                        Collections.reverseOrder(Comparator.comparing((class1) ->
                                ((class1.getKey() + 1) / (class1.getValue() + 1))
                                        - ((double) class1.getKey() / class1.getValue()))));
        for (int[] clazz : classes) {
            classesPrioritizePassRateIncrease.add(Map.entry((double) clazz[0], (double) clazz[1]));
        }

        for (int i = 0; i < extraStudents; i += 1) {
            Map.Entry<Double, Double> cur = classesPrioritizePassRateIncrease.poll();
            Map.Entry<Double, Double> updated = Map.entry(cur.getKey() + 1, cur.getValue() + 1);
            classesPrioritizePassRateIncrease.add(updated);
        }

        return classesPrioritizePassRateIncrease
                .stream()
                .mapToDouble(clazz -> (double) clazz.getKey() / clazz.getValue())
                .average()
                .getAsDouble();
    }
}
