package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description">1304. Find N Unique Integers Sum up to Zero</a></h1>
 * <h2>2025-09-07</h2>
 * <h3>Easy</h3>
 */
public class FindNUniqueIntegersSumUpToZero {
    public static void main(String[] args) {
        FindNUniqueIntegersSumUpToZero a = new FindNUniqueIntegersSumUpToZero();
        System.out.println(Arrays.toString(a.solution(6)));
        System.out.println(Arrays.toString(a.solution(5)));
        System.out.println(Arrays.toString(a.solution(3)));
        System.out.println(Arrays.toString(a.solution(1)));
    }

    public int[] solution(int n) {
        if (n == 1) {
            return new int[]{0};
        }

        int[] res = new int[n];
        for (int i = 0; i < Math.floorDiv(n, 2); i += 1) {
            res[i] = i + 1;
            res[n - 1 - i] = -(i + 1);
        }

        if (n % 2 == 1) {
            res[Math.floorDiv(n, 2)] = 0;
        }

        return res;
    }
}
