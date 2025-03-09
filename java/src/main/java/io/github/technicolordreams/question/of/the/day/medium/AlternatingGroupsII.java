package io.github.technicolordreams.question.of.the.day.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/alternating-groups-ii/description/">3208. Alternating Groups II</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-03-09</h3>
 */
public class AlternatingGroupsII {
    public static void main(String[] args) {
        AlternatingGroupsII a = new AlternatingGroupsII();
//        System.out.println(a.solution(new int[]{0, 1, 0, 1, 0}, 3));
//        System.out.println(a.solution(new int[]{0, 1, 0, 0, 1, 0, 1}, 6));
//        System.out.println(a.solution(new int[]{1, 1, 0, 1}, 4));
        System.out.println(a.solution(new int[]{0, 1, 0, 1}, 3));
    }

    public int solution(int[] colors, int k) {
        Map<Integer, Integer> alternatingGroups = new HashMap<>();
        int groupStart = 0;
        for (int i = 0; i < colors.length; i += 1) {
            if (i == colors.length - 1) {
                if (colors[i] != colors[0]) {
                    if (alternatingGroups.containsKey(0)) {
                        int prev = alternatingGroups.remove(0);
                        alternatingGroups.put(groupStart, prev);
                    } else {
                        return colors.length;
                    }
                } else {
                    alternatingGroups.put(groupStart, i);
                }
            } else {
                if (colors[i] == colors[i + 1]) {
                    alternatingGroups.put(groupStart, i);
                    groupStart = i + 1;
                }
            }
        }

        return alternatingGroups.entrySet()
                .stream()
                .mapToInt(e -> {
                    int sum = e.getValue() - e.getKey() + 1;
                    if (e.getKey() > e.getValue()) {
                        sum = colors.length - e.getKey() + e.getValue() + 1;
                    }

                    if (sum < k) {
                        return 0;
                    }

                    return sum - k + 1;
                }).sum();
    }
}
