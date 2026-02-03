package io.github.technicolordreams.question.of.the.day.easy;

public class TrionicArrayI {
    public static void main(String[] args) {
        System.out.println(TrionicArrayI.solution(new int[]{1,3,5,4,2,6}));
        System.out.println(TrionicArrayI.solution(new int[]{2,1,3}));
        System.out.println(TrionicArrayI.solution(new int[]{2,4,3,3}));
    }

    public static boolean solution(int[] nums) {
        int i = 1;
        int prev = nums[0];
        boolean inc1 = false;
        while (i < nums.length && nums[i] > prev) {
            inc1 = true;
            prev = nums[i];
            i += 1;
        }

        boolean dec = false;
        while (i < nums.length && nums[i] < prev) {
            dec = true;
            prev = nums[i];
            i += 1;
        }

        boolean inc2 = false;
        while (i < nums.length && nums[i] > prev) {
            inc2 = true;
            prev = nums[i];
            i += 1;
        }

        return i == nums.length && inc1 && dec && inc2;
    }
}
