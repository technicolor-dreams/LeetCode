package io.github.technicolordreams.top.interview.questions.array.string.medium;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/rotate-array/description">Rotate Array</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-04-15</h3>
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int[] b = {-1,-100,3,99};

        RotateArray rotateArray = new RotateArray();
        rotateArray.solution(a, 3);
        rotateArray.solution(b, 2);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public void solution(int[] nums, int k) {
        for (int i = 0; i < k; i += 1) {
            int prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j += 1) {
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }
}
