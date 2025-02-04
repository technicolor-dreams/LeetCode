package io.github.technicolordreams.top.interview.questions.intervals.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * <h1><a href="https://leetcode.com/problems/merge-intervals/description/">56. Merge Intervals</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-04</h3>
 * <h4>22:57</h4>
 */
public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals a = new MergeIntervals();

        int[][] array1 = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] array2 = {
                {1, 4},
                {4, 5}
        };

        a.solution(array1);
        a.solution(array2);
    }

    public int[][] solution(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        List<int[]> sorted =
                Arrays.stream(intervals)
                        .sorted(Comparator.comparingInt(i -> i[0]))
                        .toList();

        Stack<int[]> stack = new Stack<>();
        stack.push(sorted.getFirst());
        for (int i = 1; i < intervals.length; i += 1) {
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
