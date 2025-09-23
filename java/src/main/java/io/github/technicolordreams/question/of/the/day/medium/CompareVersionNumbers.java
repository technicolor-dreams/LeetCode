package io.github.technicolordreams.question.of.the.day.medium;

import java.util.Arrays;
import java.util.List;

/**
 * <h1><a href="https://leetcode.com/problems/compare-version-numbers?envType=daily-question&envId=2025-09-23">165. Compare Version Numbers</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-09-23</h3>
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(CompareVersionNumbers.solution("1.2", "1.10"));
        System.out.println(CompareVersionNumbers.solution("1.01", "1.001"));
        System.out.println(CompareVersionNumbers.solution("1.0", "1.0.0.0"));
    }

    public static int solution(String version1, String version2) {
        List<Integer> version1Split = Arrays.stream(version1.split("\\.")).map(Integer::valueOf).toList();
        List<Integer> version2Split = Arrays.stream(version2.split("\\.")).map(Integer::valueOf).toList();

        for (int i = 0; i < Math.max(version1Split.size(), version2Split.size()); i += 1) {
            int curVersion1 = 0;
            if (i < version1Split.size()) {
                curVersion1 = version1Split.get(i);
            }

            int curVersion2 = 0;
            if (i < version2Split.size()) {
                curVersion2 = version2Split.get(i);
            }

            if (curVersion1 == curVersion2) {
                continue;
            }

            if (curVersion1 < curVersion2) {
                return -1;
            }

            return 1;
        }

        return 0;
    }
}
