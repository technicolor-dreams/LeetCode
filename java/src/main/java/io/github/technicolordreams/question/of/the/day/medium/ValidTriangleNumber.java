package io.github.technicolordreams.question.of.the.day.medium;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/valid-triangle-number/description/?envType=daily-question&envId=2025-09-26">611. Valid Triangle Number</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-09-26</h3>
 */
public class ValidTriangleNumber {
    public static void main(String[] args) {
        int[] test1 = {2, 2, 3, 4};
        int[] test2 = {4, 2, 3, 4};

        System.out.println("Test 1 (O(n³)): " + ValidTriangleNumber.solution(test1));
        System.out.println("Test 2 (O(n³)): " + ValidTriangleNumber.solution(test2));

        System.out.println("Test 1 (O(n²)): " + ValidTriangleNumber.optimizedSolution(test1.clone()));
        System.out.println("Test 2 (O(n²)): " + ValidTriangleNumber.optimizedSolution(test2.clone()));
    }

    public static int solution(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 1) {
            int cur1 = nums[i];
            for (int j = i + 1; j < nums.length; j += 1) {
                int cur2 = nums[j];
                int min3side = Math.abs(cur1 - cur2);
                int max3side = cur1 + cur2;
                for (int k = j + 1; k < nums.length; k += 1) {
                    int cur3 = nums[k];
                    if (cur3 <= min3side) {
                        continue;
                    }

                    if (cur3 >= max3side) {
                        break;
                    }

                    res += 1;
                }
            }
        }

        return res;
    }

    public static int optimizedSolution(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        // Fix the largest side and use two pointers for the other two
        for (int k = nums.length - 1; k >= 2; k--) {
            int left = 0, right = k - 1;

            while (left < right) {
                // For a valid triangle: a + b > c (where c is the largest side)
                if (nums[left] + nums[right] > nums[k]) {
                    // All pairs (left, left+1), (left, left+2), ..., (left, right)
                    // form valid triangles with nums[k]
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }
}
