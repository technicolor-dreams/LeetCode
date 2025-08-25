package io.github.technicolordreams.question.of.the.day.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/maximum-erasure-value/description/">1695. Maximum Erasure Value</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-07-21</h3>
 */
public class MaximumErasureValue {
    public static void main(String[] args) {
        MaximumErasureValue a = new MaximumErasureValue();
        System.out.println(a.solution(new int[]{4,2,4,5,6}));
        System.out.println(a.solution(new int[]{5,2,1,2,5,2,1,2,5}));
    }

    public int solution(int[] nums) {
        int res = 0;
        int curSum = 0;
        int start = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i += 1) {
            int curNum = nums[i];
            if (seen.containsKey(curNum)) {
                for (int j = start; j < seen.get(curNum); j += 1) {
                    curSum -= nums[j];
                }

                start = seen.get(curNum) + 1;
            } else {
                curSum += curNum;
                res = Math.max(curSum, res);
            }

            seen.put(curNum, i);
        }

        return res;
    }
}
