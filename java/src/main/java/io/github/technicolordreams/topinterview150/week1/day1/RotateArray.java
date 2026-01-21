package io.github.technicolordreams.topinterview150.week1.day1;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7};
        RotateArray.solution(nums1, 3);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {-1,-100,3,99};
        RotateArray.solution(nums2, 2);
        System.out.println(Arrays.toString(nums2));
    }

    public static void solution(int[] nums, int k) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i += 1) {
            nums[(i + k) % nums.length] = copy[i];
        }
    }
}
