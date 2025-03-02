package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * <h1><a href="https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/">2570. Merge Two 2D Arrays by Summing Values</></h1>
 * <h2>Easy</h2>
 * <h3>2025-03-02</h3>
 */
public class MergeTwo2DArrayBySummingValues {
    public static void main(String[] args) {
        int[][] array1 = {
                {1, 2},
                {2, 3},
                {4, 5}
        };

        int[][] array2 = {
                {1, 4},
                {3, 2},
                {4, 1}
        };

        MergeTwo2DArrayBySummingValues a = new MergeTwo2DArrayBySummingValues();
        System.out.println(Arrays.deepToString(a.solution(array1, array2)));
    }

    public int[][] solution(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] nums : nums1) {
            map.putIfAbsent(nums[0], 0);
            map.computeIfPresent(nums[0], (k, v) -> v + nums[1]);
        }

        for (int[] nums : nums2) {
            map.putIfAbsent(nums[0], 0);
            map.computeIfPresent(nums[0], (k, v) -> v + nums[1]);
        }

        int[][] res = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[i] = new int[]{entry.getKey(), entry.getValue()};
            i += 1;
        }

        return res;
    }
}
