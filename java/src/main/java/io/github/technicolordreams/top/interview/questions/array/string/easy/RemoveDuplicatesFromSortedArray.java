package io.github.technicolordreams.top.interview.questions.array.string.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1><a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/">26. Remove Duplicates from Sorted Array</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-02-03</h3>
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray problem = new RemoveDuplicatesFromSortedArray();
//        problem.solution(new int[]{1,1,2});
        problem.solution(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
    public int solution(int[] nums) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int num : nums) {
            if (linkedList.isEmpty() || linkedList.getLast() != num) {
                linkedList.addLast(num);
            }
        }

        int res = linkedList.size();
        for (int i = 0; i < res; i += 1) {
            nums[i] = linkedList.removeFirst();
        }

        return res;
    }
}
