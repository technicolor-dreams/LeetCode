package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/">1752. Check if Array Is Sorted and Rotated</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-02-02</h3>
 */
public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        CheckIfArrayIsSortedAndRotated checkIfArrayIsSortedAndRotated = new CheckIfArrayIsSortedAndRotated();
//        System.out.println(checkIfArrayIsSortedAndRotated.solution(new int[]{3, 4, 5, 1, 2}));
//        System.out.println(checkIfArrayIsSortedAndRotated.solution(new int[]{2, 1, 3, 4}));
//        System.out.println(checkIfArrayIsSortedAndRotated.solution(new int[]{1, 2, 3}));
        System.out.println(checkIfArrayIsSortedAndRotated.solution(new int[]{2,7,4,1,2,6,2}));
    }

    public boolean solution(int[] nums) {
        if (nums.length < 3) {
            return true;
        }

        int i;
        boolean pass = true;
        for (i = 0; i < nums.length - 1; i += 1) {
            if (nums[i] > nums[i + 1]) {
                pass = false;
                break;
            }
        }

        if (pass) {
            return true;
        }

        int[] checked = new int[nums.length];
        Arrays.fill(checked, 0);
        for (; i >= 1; i -= 1) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }

            checked[i] = 1;
        }

        if (nums[0] < nums[nums.length - 1]) {
            return false;
        }

        checked[0] = 1;

        for (i = nums.length - 1; i >= 0; i -= 1) {
            if (checked[i] == 1) {
                return true;
            }

            if (checked[i - 1] == 0 && nums[i] < nums[i - 1]) {
                return false;
            }

            checked[i] = 1;
        }

        return true;
    }
}
