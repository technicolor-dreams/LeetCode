package io.github.technicolordreams.question.of.the.day.easy;

import java.util.*;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        System.out.println(MinimumAbsoluteDifference.solution(new int[]{4, 2, 1, 3}));
        System.out.println(MinimumAbsoluteDifference.solution(new int[]{1, 3, 6, 10, 15}));
        System.out.println(MinimumAbsoluteDifference.solution(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
    }

    public static List<List<Integer>> solution(int[] arr) {
        Arrays.sort(arr);
        TreeMap<Integer, Set<Map.Entry<Integer, Integer>>> diffMap = new TreeMap<>();
        for (int i = 1; i < arr.length; i += 1) {
            Map.Entry<Integer, Integer> cur = Map.entry(arr[i], arr[i - 1]);
            int diff = cur.getKey() - cur.getValue();
            diffMap.putIfAbsent(diff, new HashSet<>());
            diffMap.compute(diff, (k, v) -> {
                v.add(cur);
                return v;
            });
        }

        return diffMap
                .firstEntry()
                .getValue()
                .stream()
                .map(e -> List.of(e.getValue(), e.getKey()))
                .sorted(Comparator.comparing(List::getFirst))
                .toList();
    }
}
