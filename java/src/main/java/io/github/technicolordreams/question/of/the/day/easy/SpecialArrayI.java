package io.github.technicolordreams.question.of.the.day.easy;

/**
 * <h1><a href="https://leetcode.com/problems/special-array-i/description/">3151. Special Array I</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-02-01</h3>
 */
public class SpecialArrayI {
    public static void main(String[] args) {
        SpecialArrayI specialArrayI = new SpecialArrayI();
        specialArrayI.solution(new int[]{2, 1, 4});
    }

    public boolean solution(int[] nums) {
        if (nums.length < 2) {
            return true;
        }

        for (int i = 1; i < nums.length; i += 1) {
            if ((this.isOdd(nums[i - 1]) && this.isOdd(nums[i]))
                    || (!this.isOdd(nums[i - 1]) && !this.isOdd(nums[i]))) {
                return false;
            }

            if (i + 1 < nums.length
                    && ((this.isOdd(nums[i]) && this.isOdd(nums[i + 1]))
                    || (!this.isOdd(nums[i]) && !this.isOdd(nums[i + 1])))) {
                return false;
            }
        }

        return true;
    }

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }
}
