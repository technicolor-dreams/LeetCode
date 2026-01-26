package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public static void main(String[] args) {
        System.out.println(MinimumDifferenceBetweenHighestAndLowestOfKScores.solution(new int[]{90}, 1));
        System.out.println(MinimumDifferenceBetweenHighestAndLowestOfKScores.solution(new int[]{9,4,1,7}, 2));
    }

    public static int solution(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = k; i <= nums.length; i += 1) {
            int lower = i - k;
            int higher = i - 1;
            res = Math.min(res, nums[higher] - nums[lower]);
        }

        return res;
    }
}
