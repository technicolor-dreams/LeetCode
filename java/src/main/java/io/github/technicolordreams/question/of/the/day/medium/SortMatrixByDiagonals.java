package io.github.technicolordreams.question.of.the.day.medium;

import java.util.*;

/**
 * <h1><a href="https://leetcode.com/problems/sort-matrix-by-diagonals/description/">3446. Sort Matrix by Diagonals</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-08-28</h3>
 */
public class SortMatrixByDiagonals {
    public static void main(String[] args) {
        // First array
        int[][] arr1 = {
                {1, 7, 3},
                {9, 8, 2},
                {4, 5, 6}
        };

        // Second array
        int[][] arr2 = {
                {0, 1},
                {1, 2}
        };

        // Third array
        int[][] arr3 = {
                {1}
        };

        SortMatrixByDiagonals a = new SortMatrixByDiagonals();
        System.out.println(Arrays.deepToString(a.solution(arr1)));
        System.out.println(Arrays.deepToString(a.solution(arr2)));
        System.out.println(Arrays.deepToString(a.solution(arr3)));
    }

    public int[][] solution(int[][] grid) {

        int[][] res = new int[grid.length][grid.length];

        List<Integer> diagonal = new ArrayList<>();
        for (int k = 0; k < grid.length; k += 1) {
            diagonal.add(grid[k][k]);
        }

        diagonal.sort(Comparator.reverseOrder());
        for (int k = 0; k < grid.length; k += 1) {
            res[k][k] = diagonal.get(k);
        }

        int i = 0;
        for (int j = 1; j < grid.length; j += 1) {
            diagonal = new ArrayList<>();
            for (int k = 0; i + k < grid.length && j + k < grid.length; k += 1) {
                diagonal.add(grid[i + k][j + k]);
            }

            diagonal.sort(Comparator.naturalOrder());
            for (int k = 0; i + k < grid.length && j + k < grid.length; k += 1) {
                res[i + k][j + k] = diagonal.get(k);
            }
        }

        int j = 0;
        for (i = 1; i < grid.length; i += 1) {
            diagonal = new ArrayList<>();
            for (int k = 0; i + k < grid.length && j + k < grid.length; k += 1) {
                diagonal.add(grid[i + k][j + k]);
            }

            diagonal.sort(Comparator.reverseOrder());
            for (int k = 0; i + k < grid.length && j + k < grid.length; k += 1) {
                res[i + k][j + k] = diagonal.get(k);
            }
        }


        return res;
    }
}
