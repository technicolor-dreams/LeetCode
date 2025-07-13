package io.github.technicolordreams.question.of.the.day.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/finding-pairs-with-a-certain-sum/description/">1865. Finding Pairs With a Certain Sum</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-07-06</h3>
 */
public class FindingPairsWithACertainSum {
    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1,1,2,2,2,3}, new int[]{1,4,5,2,5,4});
        System.out.println(findSumPairs.count(7));
        findSumPairs.add(3, 2);
        System.out.println(findSumPairs.count(8));
        System.out.println(findSumPairs.count(4));
        findSumPairs.add(0, 1);
        findSumPairs.add(1, 1);
        System.out.println(findSumPairs.count(7));
    }
    static class FindSumPairs {

        private final Map<Integer, Integer> nums1;
        private final int[] nums2;
        private final Map<Integer, Integer> countMap;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = new HashMap<>();
            for (int num : nums1) {
                this.nums1.putIfAbsent(num, 0);
                this.nums1.computeIfPresent(num, (k, v) -> v + 1);
            }

            this.nums2 = nums2;
            this.countMap = new HashMap<>();
            for (int num : nums2) {
                this.countMap.putIfAbsent(num, 0);
                this.countMap.computeIfPresent(num, (k, v) -> v + 1);
            }
        }

        public void add(int index, int val) {
            int cur = this.nums2[index];
            this.countMap.computeIfPresent(cur, (k, v) -> v - 1);
            this.nums2[index] += val;
            this.countMap.putIfAbsent(this.nums2[index], 0);
            this.countMap.computeIfPresent(this.nums2[index], (k, v) -> v + 1);
            System.out.println(Arrays.toString(this.nums2));
            System.out.println(this.countMap);
        }

        public int count(int tot) {
//            int[] filtered = Arrays.stream(this.nums1)
//                    .map(num -> tot - num)
//                    .filter(num -> this.countMap.getOrDefault(num, 0) > 0)
//                    .toArray();
//            System.out.println(Arrays.toString(filtered));
//            return Math.toIntExact(
//                    Arrays.stream(this.nums1)
//                            .map(num -> tot - num)
//                            .filter(num -> this.countMap.getOrDefault(num, 0) > 0)
//                            0.count());
            return -1;
        }
    }
}
