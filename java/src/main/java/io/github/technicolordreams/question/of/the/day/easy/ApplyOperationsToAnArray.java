package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/apply-operations-to-an-array/">2460. Apply Operations to an Array</a></h1>
 * <h2>Easy</h2>
 * <h3>2024-03-01</h3>
 */
public class ApplyOperationsToAnArray {
    public static void main(String[] args) {
        ApplyOperationsToAnArray a = new ApplyOperationsToAnArray();
        System.out.println(Arrays.toString(a.solution(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(a.solution(new int[]{0, 1})));
        System.out.println(Arrays.toString(a.solution(new int[]{312, 312, 436, 892, 0, 0, 528, 0, 686, 516, 0, 0, 0, 0, 0, 445, 445, 445, 445, 445, 445, 984, 984, 984, 0, 0, 0, 0, 168, 0, 0, 647, 41, 203, 203, 241, 241, 0, 628, 628, 0, 875, 875, 0, 0, 0, 803, 803, 54, 54, 852, 0, 0, 0, 958, 195, 590, 300, 126, 0, 0, 523, 523})));
    }

    public int[] solution(int[] nums) {
        for (int i = 0; i < nums.length - 1; i += 1) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int i = 0;
        int[] res = new int[nums.length];
        Arrays.fill(res, 0);
        for (int num : nums) {
            if (num != 0) {
                res[i] = num;
                i += 1;
            }
        }

        return res;
    }
}
