package io.github.technicolordreams.topinterview150.week1.day1;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(RemoveDuplicatesFromSortedArrayII.solution(nums));
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(RemoveDuplicatesFromSortedArrayII.solution(nums1));
        System.out.println(Arrays.toString(nums1));
    }

    public static int solution(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int writePosition = 2;

        for (int readPosition = 2; readPosition < nums.length; readPosition++) {
            if (nums[readPosition] != nums[writePosition - 2]) {
                nums[writePosition] = nums[readPosition];
                writePosition++;
            }
        }

        return writePosition;
    }
}
