package io.github.technicolordreams.question.of.the.day.medium;

/**
 * <h1><a href="https://leetcode.com/problems/number-of-zero-filled-subarrays/description/">2348. Number of Zero-Filled Subarrays</a></h1>
 * <h2>2025-08-19</h2>
 */
public class NumberOfZeroFilledSubarrays {
    public static void main(String[] args) {
        NumberOfZeroFilledSubarrays a = new NumberOfZeroFilledSubarrays();
//        System.out.println(a.solution(new int[]{1,3,0,0,2,0,0,4}));
        System.out.println(a.solution(new int[]{0,0,0,2,0,0}));
//        System.out.println(a.solution(new int[]{2,10,2019}));
    }
    public long solution(int[] nums) {
        long res = 0;
        long zeroCount = 0;
        for (int i : nums) {
            if (i == 0) {
                zeroCount += 1;
            } else if (zeroCount > 0) {
                res += zeroCount * (zeroCount + 1) / 2;
                zeroCount = 0;
            }
        }

        if (zeroCount > 0) {
            res += zeroCount * (zeroCount + 1) / 2;
        }

        return res;
    }
}
