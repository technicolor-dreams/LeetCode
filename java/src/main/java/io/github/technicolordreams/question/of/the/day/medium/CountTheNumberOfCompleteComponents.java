package io.github.technicolordreams.question.of.the.day.medium;

import java.util.*;

public class CountTheNumberOfCompleteComponents {
    public static void main(String[] args) {
        CountTheNumberOfCompleteComponents a = new CountTheNumberOfCompleteComponents();

//        int[][] edges1 = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
//        int n1 = 6;
//
//        System.out.println(a.solution(n1, edges1));
//
//        int[][] edges2 = {{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}};
//        int n2 = 6;
//
//        System.out.println(a.solution(n2, edges2));
//
//        int[][] edges3 = {{1, 0}};
//        int n3 = 3;
//
//        System.out.println(a.solution(n3, edges3));

        int[][] edges4 = {{1, 0}};
        int n4 = 4;

        System.out.println(a.solution(n4, edges4));
    }

    public int solution(int n, int[][] edges) {
        if (edges.length == 0) {
            return n;
        }

        int[][] adjacencyMatrix = new int[n][n];
        for (int[] row : adjacencyMatrix) {
            Arrays.fill(row, 0);
        }

        for (int[] edge : edges) {
            adjacencyMatrix[edge[0]][edge[1]] = 1;
            adjacencyMatrix[edge[1]][edge[0]] = 1;
        }

        int[] seen = new int[n];
        Arrays.fill(seen, 0);

        List<Map.Entry<Integer, Integer>> components = new ArrayList<>();
        for (int i = 0; i < n; i += 1) {
            if (seen[i] == 1) {
                continue;
            }

            Map.Entry<Integer, Integer> curComponent = Map.entry(0, 0);
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            while (!stack.empty()) {
                int cur = stack.pop();
                if (seen[cur] == 1) {
                    continue;
                }

                seen[cur] = 1;
                int edgeCount = 0;
                for (int j = 0; j < n; j += 1) {
                    if (adjacencyMatrix[cur][j] == 1 && seen[j] == 0) {
                        stack.push(j);
                        edgeCount += 1;
                    }
                }

                curComponent = Map.entry(
                        curComponent.getKey() + 1,
                        curComponent.getValue() + edgeCount);
            }

            components.add(curComponent);
        }

        return (int) components.stream().filter(this::isConnected).count();
    }

    private boolean isConnected(Map.Entry<Integer, Integer> entry) {
        return entry.getValue() == (entry.getKey() * (entry.getKey() - 1) / 2);
    }
}
