package io.github.technicolordreams.question.of.the.day.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <h1><a href="https://leetcode.com/problems/tuple-with-same-product/description/">1726. Tuple with Same Product</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-06</h3>
 */
public class TupleWithSameProduct {
    public static void main(String[] args) {
        TupleWithSameProduct a = new TupleWithSameProduct();
        System.out.println(a.solution(new int[]{2,3,4,6}));
        System.out.println(a.solution(new int[]{1,2,4,5,10}));
    }
    public int solution(int[] nums) {
        Map<Integer, Set<Set<Integer>>> productMap = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i += 1) {
            int finalI = i;
            for (int j = i + 1; j < nums.length; j += 1) {
                int currentProduct = nums[i] * nums[j];
                productMap.putIfAbsent(currentProduct, new HashSet<>());
                int finalJ = j;
                productMap.computeIfPresent(currentProduct, (k, v) -> {
                    Set<Integer> indexes = Set.of(finalI, finalJ);
                    v.add(indexes);
                    return v;
                });
            }
        }

        return productMap.values()
                .stream()
                .map(Set::size)
                .filter(size -> size >= 2)
                .map(TupleWithSameProduct::getNumberOfCombinations)
                .map(n -> n * 4)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static final Map<Integer, Integer> mem = new HashMap<>();
    private static int getNumberOfCombinations(int n) {
        if (mem.containsKey(n)) {
            return mem.get(n);
        }

        int result = 1;
        for (int i = 0; i < 2; i++) {
            result *= (n - i);
        }

        mem.put(n, result);
        return result;
    }
}
