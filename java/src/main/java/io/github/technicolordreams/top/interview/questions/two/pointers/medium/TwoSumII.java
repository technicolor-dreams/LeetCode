package io.github.technicolordreams.top.interview.questions.two.pointers.medium;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/">167. Two Sum II - Input Array Is Sorted</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-01</h3>
 */
public class TwoSumII {
    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        System.out.println(Arrays.toString(twoSumII.solution(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSumII.solution(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(twoSumII.solution(new int[]{-1, 0}, -1)));
    }

    public int[] solution(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i += 1) {
            int curI = numbers[i];
            for (int j = i + 1; j < numbers.length; j += 1) {
                int curJ = numbers[j];
                if (curI + curJ == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{};
    }
}
