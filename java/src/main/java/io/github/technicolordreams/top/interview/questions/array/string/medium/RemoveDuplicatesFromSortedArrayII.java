package io.github.technicolordreams.top.interview.questions.array.string.medium;

import io.github.technicolordreams.top.interview.questions.array.string.easy.RemoveDuplicatesFromSortedArray;

import java.util.LinkedList;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">80. Remove Duplicates from Sorted Array II</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-03</h3>
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII problem = new RemoveDuplicatesFromSortedArrayII();
        problem.solution(new int[]{1,1,1,2,2,3});
    }
    public int solution(int[] nums) {
        LinkedList<Map.Entry<Integer, Integer>> linkedList = new LinkedList<>();
        for (int num : nums) {
            if (linkedList.isEmpty() || linkedList.getLast().getKey() != num) {
                linkedList.addLast(Map.entry(num, 1));
                continue;
            }

            if (linkedList.getLast().getKey() == num && linkedList.getLast().getValue() == 1) {
                linkedList.removeLast();
                linkedList.addLast(Map.entry(num, 2));
            }
        }

        int i = 0;
        while (!linkedList.isEmpty()) {
            Map.Entry<Integer, Integer> cur = linkedList.removeFirst();
            for (int j = 0; j < cur.getValue(); j += 1) {
                nums[i] = cur.getKey();
                i += 1;
            }
        }

        return i;
    }
}
