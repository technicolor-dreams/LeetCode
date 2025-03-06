package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/find-missing-and-repeated-values/description/">2965. Find Missing and Repeated Values</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-03-06</h3>
 */
public class FindMissingAndRepeatedValues {
    public int[] solution(int[][] grid) {
        int[] seen = new int[grid.length * grid.length];
        Arrays.fill(seen, 0);

        int[] res = new int[2];
        for (int i = 0; i < grid.length; i += 1) {
            for (int j = 0; j < grid.length; j += 1) {
                int cur = grid[i][j];
                if (seen[cur - 1] != 0) {
                    res[0] = cur;
                    continue;
                }

                seen[cur - 1] = cur;
            }
        }

        for (int i = 0; i < seen.length; i += 1) {
            if (seen[i] == 0) {
                res[1] = i + 1;
                return res;
            }
        }

        return res;
    }
}
