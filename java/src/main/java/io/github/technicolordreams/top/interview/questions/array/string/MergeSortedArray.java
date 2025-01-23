package io.github.technicolordreams.top.interview.questions.array.string;

/**
 * <h1><a href="https://leetcode.com/problems/merge-sorted-array/description/">88. Merge Sorted Array</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-23</h3>
 */
public class MergeSortedArray {
    public static void solution(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[k] = nums1[i];
                    i -= 1;
                } else {
                    nums1[k] = nums2[j];
                    j -= 1;
                }
            } else if (i >= 0) {
                nums1[k] = nums1[i];
                i -= 1;
            } else {
                nums1[k] = nums2[j];
                j -= 1;
            }

            k -= 1;
        }
    }
}
