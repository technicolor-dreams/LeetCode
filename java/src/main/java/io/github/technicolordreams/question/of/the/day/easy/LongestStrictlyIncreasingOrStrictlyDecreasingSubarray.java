package io.github.technicolordreams.question.of.the.day.easy;

/**
 * <h1><a href="https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/">3105. Longest Strictly Increasing or Strictly Decreasing Subarray</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-02-03</h3>
 */
public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public int solution(int[] nums) {
        int res = 1;
        int incLength = 1;
        int decLength = 1;
        for (int i = 0; i < nums.length - 1; i += 1) {
            if (nums[i] < nums[i + 1]) {
                incLength += 1;
                decLength = 1;
            } else if (nums[i] > nums[i + 1]) {
                decLength += 1;
                incLength = 1;
            } else {
                decLength = 1;
                incLength = 1;
            }

            res = Math.max(Math.max(incLength, decLength), res);
        }

        return res;
    }
}
