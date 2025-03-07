package io.github.technicolordreams.question.of.the.day.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1><a href="https://leetcode.com/problems/closest-prime-numbers-in-range/description">2523. Closest Prime Numbers in Range</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-03-07</h3>
 */
public class ClosestPrimeNumbersInRange {
    public static void main(String[] args) {
        ClosestPrimeNumbersInRange a = new ClosestPrimeNumbersInRange();
        System.out.println(Arrays.toString(a.solution(19, 31)));
//        System.out.println(Arrays.toString(a.solution(4, 6)));
//        System.out.println(Arrays.toString(a.solution(10, 19)));
    }

    public int[] solution(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true); // Assume all numbers are prime
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false; // Mark multiples as non-prime
                }
            }
        }
        int[] res = new int[2];
        Arrays.fill(res, -1);
        int prev = -1;
        for (int i = left; i <= right; i += 1) {
            if (!isPrime[i]) {
                continue;
            }

            if (prev == -1) {
                prev = i;
            } else {
                if (res[0] == -1) {
                    res[0] = prev;
                    res[1] = i;
                } else if (i - prev < res[1] - res[0]) {
                    res[0] = prev;
                    res[1] = i;
                }

                prev = i;
            }
        }

        return res;
    }
}
