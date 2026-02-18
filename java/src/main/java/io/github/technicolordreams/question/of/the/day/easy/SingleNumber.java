package io.github.technicolordreams.question.of.the.day.easy;

/**
 * nums is list of matching pairs and one single number with no pair. Find the single number with no pair.
 */
public class SingleNumber {
    public static void main(String[] args) {
        // Basic cases
        System.out.println(SingleNumber.solution(new int[]{2, 2, 1}));              // 1
        System.out.println(SingleNumber.solution(new int[]{4, 1, 2, 1, 2}));        // 4
        System.out.println(SingleNumber.solution(new int[]{1}));                    // 1 (single element)

        // Single at different positions
        System.out.println(SingleNumber.solution(new int[]{7, 3, 3}));              // 7 (single at start)
        System.out.println(SingleNumber.solution(new int[]{3, 7, 3}));              // 7 (single in middle)
        System.out.println(SingleNumber.solution(new int[]{3, 3, 7}));              // 7 (single at end)

        // Negative numbers
        System.out.println(SingleNumber.solution(new int[]{-1, -1, -2}));           // -2
        System.out.println(SingleNumber.solution(new int[]{-3, 1, 1, -3, 5}));     // 5

        // Larger array
        System.out.println(SingleNumber.solution(new int[]{1, 2, 3, 4, 3, 2, 1})); // 4
    }

    public static int solution(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }

        return res;
    }
}
