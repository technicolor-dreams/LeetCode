package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Arrays;

public class TransformedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(TransformedArray.solution(new int[]{3, -2, 1, 1})));
        System.out.println(Arrays.toString(TransformedArray.solution(new int[]{-1, 4, -1})));
        System.out.println(Arrays.toString(TransformedArray.solution(new int[]{-10})));
    }

    public static int[] solution(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i += 1) {
            res[i] = nums[getTransformedIndex(nums, i)];
        }

        return res;
    }

    private static int getTransformedIndex(int[] nums, int i) {
        int j = i + nums[i];
        while (j >= nums.length) {
            j -= nums.length;
        }
        while (j < 0) {
            j += nums.length;
        }

        return j;
    }
}
