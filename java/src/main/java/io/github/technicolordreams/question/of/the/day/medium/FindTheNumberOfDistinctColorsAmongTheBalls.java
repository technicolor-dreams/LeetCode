package io.github.technicolordreams.question.of.the.day.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/">3160. Find the Number of Distinct Colors Among the Balls</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-07</h3>
 * <h4>6:10</h4>
 */
public class FindTheNumberOfDistinctColorsAmongTheBalls {
    public static void main(String[] args) {
        FindTheNumberOfDistinctColorsAmongTheBalls a = new FindTheNumberOfDistinctColorsAmongTheBalls();
        int[][] arrayOfArrays = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        System.out.println(Arrays.toString(a.solution(4, arrayOfArrays)));
    }

    public int[] solution(int limit, int[][] queries) {
        int[] res = new int[queries.length];
        Map<Integer, Integer> ballMap = new HashMap<>();
        Map<Integer, Integer> colorMap = new HashMap<>();
        for (int i = 0; i < queries.length; i += 1) {
            int[] curQuery = queries[i];
            int curBall = curQuery[0];
            int curColor = curQuery[1];
            if (ballMap.containsKey(curBall)) {
                colorMap.computeIfPresent(ballMap.get(curBall), (k, v) -> v - 1);
                if (colorMap.get(ballMap.get(curBall)) == 0) {
                    colorMap.remove(ballMap.get(curBall));
                }
            }

            ballMap.put(curBall, curColor);
            colorMap.putIfAbsent(curColor, 0);
            colorMap.computeIfPresent(curColor, (k, v) -> v + 1);
            res[i] = colorMap.size();
        }

        return res;
    }
}
