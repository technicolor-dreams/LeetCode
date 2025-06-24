package io.github.technicolordreams.question.of.the.day.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1><a href="https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/">2200. Find All K-Distant Indices in an Array</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-06-24</h3>
 */
public class FindAllKDistantIndicesInAnArray {
    public static void main(String[] args) {
        FindAllKDistantIndicesInAnArray a = new FindAllKDistantIndicesInAnArray();
        System.out.println(a.solution(new int[]{3,4,9,1,3,9,5}, 9, 1));
        System.out.println(a.solution(new int[]{2,2,2,2,2}, 2, 2));
    }

    public List<Integer> solution(int[] nums, int key, int k) {
        Set<Integer> keyIndexes = new HashSet<>();
        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] == key) {
                keyIndexes.add(i);
            }
        }

        Set<Integer> res = new HashSet<>();
        for (int keyIndex : keyIndexes) {
            for (int i = 0; i <= k && keyIndex - i >= 0; i += 1) {
                res.add(keyIndex - i);
            }

            for (int i = 0; i <= k && keyIndex + i < nums.length; i += 1) {
                res.add(keyIndex + i);
            }
        }

        return res.stream().sorted().toList();
    }
}
