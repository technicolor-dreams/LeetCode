package io.github.technicolordreams.top.interview.questions.array.string;

/**
 * <h1><a href="https://leetcode.com/problems/remove-element/description/">27. Remove Element</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-23</h3>
 */
public class RemoveElement {
    public static int solution(int[] nums, int val) {
        int res = nums.length;
        int j = -1;
        for (int i = nums.length - 1; i >= 0; i -= 1) {
            if (nums[i] == val) {
                res -= 1;
                if (j > 0) {
                    nums[i] = nums[j];
                    j -= 1;
                }
            } else if (j == -1) {
                j = i;
            }
        }

        return res;
    }
}
