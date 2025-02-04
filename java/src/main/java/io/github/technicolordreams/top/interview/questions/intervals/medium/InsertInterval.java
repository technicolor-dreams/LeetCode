package io.github.technicolordreams.top.interview.questions.intervals.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * <h1><a href="https://leetcode.com/problems/insert-interval/description/">57. Insert Interval</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-04</h3>
 * <
 */
public class InsertInterval {
    public static void main(String[] args) {
        InsertInterval a = new InsertInterval();

        // Define the first 2D array
        int[][] array1 = {
                {1, 3},
                {6, 9}
        };

        // Define the second 2D array
        int[][] array2 = {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };

        a.solution(array1, new int[]{2, 5});
        a.solution(array2, new int[]{4, 8});
    }
    public int[][] solution(int[][] intervals, int[] newInterval) {
        List<int[]> sorted =
                Stream.concat(Arrays.stream(intervals), Stream.of(newInterval))
                        .sorted(Comparator.comparingInt(i -> i[0]))
                        .toList();

        Stack<int[]> stack = new Stack<>();
        stack.push(sorted.getFirst());
        for (int i = 1; i < sorted.size(); i += 1) {
            int[] fromStack = stack.pop();
            int[] cur = sorted.get(i);
            if (this.areIntervalsMergeable(fromStack, cur)) {
                stack.push(this.mergeIntervals(fromStack, cur));
            } else {
                stack.push(fromStack);
                stack.push(cur);
            }
        }

        int[][] res = new int[stack.size()][2];
        for (int i = res.length - 1; i >= 0; i -= 1) {
            res[i] = stack.pop();
        }

        return res;
    }

    private boolean areIntervalsMergeable(int[] i1, int[] i2) {
        return Math.max(i1[0], i2[0]) <= Math.min(i1[1], i2[1]);
    }

    private int[] mergeIntervals(int[] i1, int[] i2) {
        int left = Math.min(i1[0], i2[0]);
        int right = Math.max(i1[1], i2[1]);
        return new int[]{left, right};
    }
}
