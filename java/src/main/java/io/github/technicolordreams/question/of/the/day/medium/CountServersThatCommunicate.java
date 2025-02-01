package io.github.technicolordreams.question.of.the.day.medium;

import java.util.*;

/**
 * <h1><a href="https://leetcode.com/problems/count-servers-that-communicate/">1267. Count Servers that Communicate</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-01-23</h3>
 */
public class CountServersThatCommunicate {
    public static void main(String[] args) {
//        System.out.println(CountServersThatCommunicate.solution(new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
//        System.out.println(CountServersThatCommunicate.solution(new int[][]{new int[]{1, 0}, new int[]{1, 1}}));
//        System.out.println(CountServersThatCommunicate.solution(new int[][]{
//                new int[]{1, 1, 0, 0},
//                new int[]{0, 0, 1, 0},
//                new int[]{0, 0, 1, 0},
//                new int[]{0, 0, 0, 1}
//        }));
//
//        int[][] arrayOfArrays = {
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 1, 0, 0, 1, 0, 0}
//        };
//
//        System.out.println(CountServersThatCommunicate.solution(arrayOfArrays));

        int[][] array = {
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 1}
        };

        System.out.println(CountServersThatCommunicate.solution(array));
    }

    public static int solution(int[][] grid) {
        int[] rowServer = new int[grid.length];
        int[] columnServer = new int[grid[0].length];

        Arrays.fill(rowServer, 0);
        Arrays.fill(columnServer, 0);

        for (int i = 0; i < grid.length; i += 1) {
            for (int j = 0; j < grid[i].length; j += 1) {
                if (grid[i][j] == 1) {
                    rowServer[i] += 1;
                    columnServer[j] += 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < grid.length; i += 1) {
            for (int j = 0; j < grid[i].length; j += 1) {
                if (grid[i][j] == 1 && (rowServer[i] > 1 || columnServer[j] > 1)) {
                    res += 1;
                }
            }
        }

        return res;
    }
}
