package io.github.technicolordreams.question.of.the.day;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1><a href="https://leetcode.com/problems/find-eventual-safe-states/description">802. Find Eventual Safe States</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-01-24</h3>
 */
public class FindEventualSafeStates {
    public static void main(String[] args) {
        int[][] test1 = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        System.out.println(solution(test1));
    }

    public static List<Integer> solution(int[][] graph) {
        Set<Integer> res = new HashSet<>();

        class Recurs {
            public boolean recurse(int i, Set<Integer> seen) {
                if (seen.contains(i)) {
                    return false;
                }

                seen.add(i);

                if (res.contains(i)) {
                    return true;
                }

                for (int j : graph[i]) {
                    if (res.contains(j)) {
                        continue;
                    }

                    if (!this.recurse(j, seen)) {
                        return false;
                    }

                    res.add(j);
                }

                return true;
            }
        }

        Recurs recurs = new Recurs();
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < graph.length; i += 1) {
            if (res.contains(i)) {
                continue;
            }

            if (recurs.recurse(i, seen)) {
                res.add(i);
            }

            seen.clear();
        }

        return res.stream().sorted().toList();
    }
}
