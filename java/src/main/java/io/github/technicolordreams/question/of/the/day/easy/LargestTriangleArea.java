package io.github.technicolordreams.question.of.the.day.easy;

/**
 * <h1><a href="https://leetcode.com/problems/largest-triangle-area/description/?envType=daily-question&envId=2025-09-27">812. Largest Triangle Area</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-09-27</h3>
 */
public class LargestTriangleArea {
    public static void main(String[] args) {
        int[][] points1 = {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        int[][] points2 = {{1, 0}, {0, 0}, {0, 1}};

        System.out.println("Test case 1: " + solution(points1));
        System.out.println("Test case 2: " + solution(points2));
    }

    public static double solution(int[][] points) {
        double res = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i += 1) {
            int[] p1 = points[i];
            for (int j = i + 1; j < points.length; j += 1) {
                int[] p2 = points[j];
                for (int k = j + 1; k < points.length; k += 1) {
                    int[] p3 = points[k];
                    double area =
                            0.5 * Math.abs(p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1]));
                    res = Math.max(res, area);
                }
            }
        }

        return res;
    }
}
