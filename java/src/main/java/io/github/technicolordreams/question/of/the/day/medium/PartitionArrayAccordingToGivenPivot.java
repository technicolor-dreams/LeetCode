package io.github.technicolordreams.question.of.the.day.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1><a href="https://leetcode.com/problems/partition-array-according-to-given-pivot/description/"> 2161. Partition Array According to Given Pivot</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-03-03</h3>
 * <h4>4m1s</h4>
 */
public class PartitionArrayAccordingToGivenPivot {
    public static void main(String[] args) {
        PartitionArrayAccordingToGivenPivot a = new PartitionArrayAccordingToGivenPivot();

        System.out.println(Arrays.toString(a.solution(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
        System.out.println(Arrays.toString(a.solution(new int[]{-3, 4, 3, 2}, 2)));
    }

    public int[] solution(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        int equals = 0;
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num > pivot) {
                more.add(num);
            } else {
                equals += 1;
            }
        }

        int i = 0;
        for (int num : less) {
            nums[i] = num;
            i += 1;
        }

        for (int j = 0; j < equals; j += 1) {
            nums[i] = pivot;
            i += 1;
        }

        for (int num : more) {
            nums[i] = num;
            i += 1;
        }

        return nums;
    }
}
