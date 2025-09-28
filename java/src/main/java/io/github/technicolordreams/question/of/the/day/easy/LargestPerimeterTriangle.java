package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <h1><a href="https://leetcode.com/problems/largest-perimeter-triangle/?envType=daily-question&envId=2025-09-28">976. Largest Perimeter Triangle</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-09-28</h3>
 */
public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        LargestPerimeterTriangle solution = new LargestPerimeterTriangle();

        int[] test1 = {2, 1, 2};
        int result1 = solution.solution(test1);
        System.out.println("Input: [2,1,2], Output: " + result1);

        int[] test2 = {1, 2, 1, 10};
        int result2 = solution.solution(test2);
        System.out.println("Input: [1,2,1,10], Output: " + result2);
    }

    public int solution(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 2; i -= 1) {
            int iCur = nums[i];
            int jCur = nums[i - 1];
            int kCur = nums[i - 2];

            if (jCur + kCur > iCur) {
                return iCur + jCur + kCur;
            }
        }

        return res;
    }
}
