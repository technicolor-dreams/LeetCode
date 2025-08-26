package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/">3000. Maximum Area of Longest Diagonal Rectangle</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-08-26</h3>
 */
public class MaximumAreaOfLongestDiagonalRectangle {
    public static void main(String[] args) {
        MaximumAreaOfLongestDiagonalRectangle a = new MaximumAreaOfLongestDiagonalRectangle();

        int[][] arr1 = {
                {9, 3},
                {8, 6},
                {9, 3},
                {8, 9}
        };

        int[][] arr2 = {
                {3, 4},
                {4, 3}
        };

        System.out.println(a.solution(arr1));
        System.out.println(a.solution(arr2));
    }

    public int solution(int[][] dimensions) {
        Arrays.sort(dimensions, (dim1, dim2) -> {
            int diag1 = dim1[0] * dim1[0] + dim1[1] * dim1[1];
            int diag2 = dim2[0] * dim2[0] + dim2[1] * dim2[1];
            int diagComp = Integer.compare(diag2, diag1);
            if (diagComp == 0) {
                int area1 = dim1[0] * dim1[1];
                int area2 = dim2[0] * dim2[1];
                return Integer.compare(area2, area1);
            }

            return diagComp;
        });

        return dimensions[0][0] * dimensions[0][1];
    }
}
