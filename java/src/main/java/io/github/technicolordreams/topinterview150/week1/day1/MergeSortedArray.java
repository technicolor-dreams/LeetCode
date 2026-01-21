package io.github.technicolordreams.topinterview150.week1.day1;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] numsA1 = {1, 2, 3, 0, 0, 0};
        int[] numsA2 = {2, 5, 6};
        MergeSortedArray.solution(numsA1, 3, numsA2, 3);
        System.out.println(Arrays.toString(numsA1));
    }

    public static void solution(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = m - 1;
        int cur2 = n - 1;
        int cur3 = m + n - 1;
        while (cur1 >= 0 || cur2 >= 0) {
            if (cur1 >= 0 && cur2 >= 0) {
                if (nums1[cur1] > nums2[cur2]) {
                    nums1[cur3] = nums1[cur1];
                    cur1 -= 1;
                } else {
                    nums1[cur3] = nums2[cur2];
                    cur2 -= 1;
                }
            } else if (cur1 >= 0) {
                nums1[cur3] = nums1[cur1];
                cur1 -= 1;
            } else {
                nums1[cur3] = nums2[cur2];
                cur2 -= 1;
            }

            cur3 -= 1;
        }
    }
}
