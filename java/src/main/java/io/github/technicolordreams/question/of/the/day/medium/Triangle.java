package io.github.technicolordreams.question.of.the.day.medium;

import java.util.List;
import java.util.function.Function;

/**
 * <h1><a href="https://leetcode.com/problems/triangle/description/?envType=daily-question&envId=2025-09-25">120. Triangle</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-09-25</h3>
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> test1 = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );

        List<List<Integer>> test2 = List.of(
                List.of(-10)
        );

        List<List<Integer>> test3 = List.of(
                List.of(-1),
                List.of(2, 3),
                List.of(1, -1, -3)
        );

        System.out.println("Test 1: " + Triangle.bottomToTopSolution(test1));
        System.out.println("Test 2: " + Triangle.bottomToTopSolution(test2));
        System.out.println("Test 3: " + Triangle.bottomToTopSolution(test3));
    }

    public static int topToBottomSolution(List<List<Integer>> triangle) {
        class Recurs {
            int run(int minRes, int curRow, int curIndex) {
                if (curRow == triangle.size()) {
                    return minRes;
                }

                return Math.min(
                        run(minRes + triangle.get(curRow).get(curIndex), curRow + 1, curIndex),
                        run(minRes + triangle.get(curRow).get(curIndex), curRow + 1, curIndex + 1));
            }
        }

        Recurs recurs = new Recurs();
        return recurs.run(0, 0, 0);
    }

    public static int bottomToTopSolution(List<List<Integer>> triangle) {
        for (int row = triangle.size() - 2; row >= 0; row -= 1) {
            for (int entry = 0; entry < triangle.get(row).size(); entry += 1) {
                List<Integer> belowRow = triangle.get(row + 1);
                int minEntry = triangle.get(row).get(entry) + Math.min(belowRow.get(entry), belowRow.get(entry + 1));
                triangle.get(row).set(entry, minEntry);
            }
        }

        return triangle.getFirst().getFirst();
    }

}
