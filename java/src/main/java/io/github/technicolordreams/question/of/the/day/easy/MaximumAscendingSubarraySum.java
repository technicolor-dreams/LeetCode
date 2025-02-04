package io.github.technicolordreams.question.of.the.day.easy;

/**
 * <h1><a href="https://leetcode.com/problems/maximum-ascending-subarray-sum/description/">1800. Maximum Ascending Subarray Sum</a></h1>
 * <h2>Easy</h2>
 * <h3>2024-02-04</h3>
 */
public class MaximumAscendingSubarraySum {
    public static void main(String[] args) {
        MaximumAscendingSubarraySum problem = new MaximumAscendingSubarraySum();
        System.out.println(problem.solution(new int[]{10,20,30,5,10,50}));
        System.out.println(problem.solution(new int[]{10,20,30,40,50}));
        System.out.println(problem.solution(new int[]{12,17,15,13,10,11,12}));
    }

    public int solution(int[] nums) {
        int res = 0;
        int curMax = 0;
        for (int i = 0; i < nums.length; i += 1) {
            int cur = nums[i];
            curMax += cur;
            if (i < nums.length - 1 && cur >= nums[i + 1]) {
                res = Math.max(res, curMax);
                curMax = 0;
            }
        }

        res = Math.max(res, curMax);

        return res;
    }
}
