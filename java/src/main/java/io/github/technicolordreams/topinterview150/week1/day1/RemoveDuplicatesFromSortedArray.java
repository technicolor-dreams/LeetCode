package io.github.technicolordreams.topinterview150.week1.day1;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        System.out.println(RemoveDuplicatesFromSortedArray.solution(nums1));
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(RemoveDuplicatesFromSortedArray.solution(nums2));
        System.out.println(Arrays.toString(nums2));
    }

    public static int solution(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int writePosition = 1;

        for (int readPosition = 1; readPosition < nums.length; readPosition++) {
            if (nums[readPosition] != nums[writePosition - 1]) {
                nums[writePosition] = nums[readPosition];
                writePosition++;
            }
        }

        return writePosition;
    }
}
