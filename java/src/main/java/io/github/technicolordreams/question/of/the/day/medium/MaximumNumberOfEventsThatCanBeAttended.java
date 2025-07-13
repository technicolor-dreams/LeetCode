package io.github.technicolordreams.question.of.the.day.medium;

import java.util.*;

/**
 * <h1><a href="https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/">1353. Maximum Number of Events That Can Be Attended</a></h1>
 * <h2>2025-07-07</h2>
 * <h3>Medium</h3>
 */
public class MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        MaximumNumberOfEventsThatCanBeAttended a = new MaximumNumberOfEventsThatCanBeAttended();
        System.out.println(a.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(a.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(a.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}}));
    }

    public int solution(int[][] events) {
        List<int[]> sortedEvents =
                Arrays.stream(events).sorted((e1, e2) -> {
                    if (e1[0] > e2[0]) {
                        return 1;
                    } else if (e1[0] < e2[0]) {
                        return -1;
                    } else {
                        if (e1[1] > e2[1]) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }).toList();



        return -1;
    }
}
