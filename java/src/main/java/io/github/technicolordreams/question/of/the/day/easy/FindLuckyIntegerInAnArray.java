package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FindLuckyIntegerInAnArray {
    public int solution(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.putIfAbsent(num, 0);
            count.computeIfPresent(num, (k, v) -> v + 1);
        }

        return count
                .entrySet()
                .stream()
                .filter(e -> Objects.equals(e.getKey(), e.getValue()))
                .map(Map.Entry::getKey)
                .max(Comparator.naturalOrder())
                .orElse(-1);
    }
}
