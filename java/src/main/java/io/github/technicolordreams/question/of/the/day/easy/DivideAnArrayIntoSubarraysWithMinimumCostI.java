package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Arrays;

public class DivideAnArrayIntoSubarraysWithMinimumCostI {
    public static void main(String[] args) {
        System.out.println(DivideAnArrayIntoSubarraysWithMinimumCostI.solution(new int[]{1, 2, 3, 12}));
        System.out.println(DivideAnArrayIntoSubarraysWithMinimumCostI.solution(new int[]{5, 4, 3}));
        System.out.println(DivideAnArrayIntoSubarraysWithMinimumCostI.solution(new int[]{10, 3, 1, 1}));
    }

    public static int solution(int[] nums) {
        int[] subarray = Arrays.copyOfRange(nums, 1, nums.length);
        Arrays.sort(subarray);
        return nums[0] + subarray[0] + subarray[1];
    }
}
