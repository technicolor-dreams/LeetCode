package io.github.technicolordreams.question.of.the.day.medium;

/**
 * <h1><a href="https://leetcode.com/problems/count-total-number-of-colored-cells/description/">2579. Count Total Number of Colored Cells</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-03-05</h3>
 */
public class CountTotalNumberOfColoredCells {
    public static void main(String[] args) {
        CountTotalNumberOfColoredCells a = new CountTotalNumberOfColoredCells();
        System.out.println(a.solution(1));
        System.out.println(a.solution(2));
    }

    public long solution(int n) {
        if (n == 1) {
            return 1;
        }

        return (long) (Math.pow(n, 2) + Math.pow(n - 1, 2));
    }
}
