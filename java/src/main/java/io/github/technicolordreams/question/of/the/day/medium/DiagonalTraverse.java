package io.github.technicolordreams.question.of.the.day.medium;

import java.util.*;

/**
 * <h1><a href="https://leetcode.com/problems/diagonal-traverse/description/">498. Diagonal Traverse</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-08-25</h3>
 */
public class DiagonalTraverse {
    public static void main(String[] args) {
        DiagonalTraverse a = new DiagonalTraverse();

        int[][] arr1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] arr2 = {
                {1, 2},
                {3, 4}
        };

        int[][] arr3 = {
                {1, 2, 5},
                {3, 4, 6}
        };

        System.out.println(Arrays.toString(a.solution(arr1)));
        System.out.println(Arrays.toString(a.solution(arr2)));
        System.out.println(Arrays.toString(a.solution(arr3)));
    }

    public int[] solution(int[][] mat) {

        Map<Integer, LinkedList<Map.Entry<Integer, Integer>>> indexSumMap = new TreeMap<>();
        for (int i = 0; i < mat.length; i += 1) {
            for (int j = 0; j < mat[0].length; j += 1) {
                int d = i + j;
                indexSumMap.putIfAbsent(d, new LinkedList<>());
                Map.Entry<Integer, Integer> entry = Map.entry(i, j);
                indexSumMap.computeIfPresent(d, (k, v) -> {
                    v.add(entry);
                    return v;
                });
            }
        }

        int[] res = new int[mat.length * mat[0].length];
        int i = 0;
        for (Map.Entry<Integer, LinkedList<Map.Entry<Integer, Integer>>> entry : indexSumMap.entrySet()) {
            LinkedList<Map.Entry<Integer, Integer>> val =
                    entry.getKey() % 2 == 0
                            ? entry.getValue().reversed()
                            : entry.getValue();

            for (Map.Entry<Integer, Integer> cell : val) {
                res[i] = mat[cell.getKey()][cell.getValue()];
                i += 1;
            }
        }

        return res;
    }
}
