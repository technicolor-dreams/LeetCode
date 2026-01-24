package io.github.technicolordreams.question.of.the.day.medium;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    public static void main(String[] args) {
        System.out.println(MinimizeMaximumPairSumInArray.solution(new int[]{3, 5, 2, 3}));
        System.out.println(MinimizeMaximumPairSumInArray.solution(new int[]{3, 5, 4, 2, 4, 6}));
    }

    public static int solution(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int half = nums.length / 2;
        for (int i = 0; i < half; i += 1) {
            res = Math.max(res, nums[i] + nums[nums.length - 1 - i]);
        }

        return res;
    }
}
