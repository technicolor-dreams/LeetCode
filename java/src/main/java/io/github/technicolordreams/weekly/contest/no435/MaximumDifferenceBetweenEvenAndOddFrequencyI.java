package io.github.technicolordreams.weekly.contest.no435;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/contest/weekly-contest-435/problems/maximum-difference-between-even-and-odd-frequency-i/">Q1. Maximum Difference Between Even and Odd Frequency I</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-02-05</h3>
 */
public class MaximumDifferenceBetweenEvenAndOddFrequencyI {
    public static void main(String[] args) {
        MaximumDifferenceBetweenEvenAndOddFrequencyI a = new MaximumDifferenceBetweenEvenAndOddFrequencyI();
        System.out.println(a.solution("aaaaabbc"));
        System.out.println(a.solution("abcabcab"));
    }

    public int solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.computeIfPresent(c, (k, v) -> v + 1);
        }

        List<Integer> sortedFreq = map.values().stream().sorted().toList();

        int largestOdd = 0;
        for (int i = sortedFreq.size() - 1; i >= 0; i -= 1) {
            int cur = sortedFreq.get(i);
            if (cur % 2 == 1) {
                largestOdd = cur;
                break;
            }
        }

        int smallestEven = 0;
        for (int cur : sortedFreq) {
            if (cur % 2 == 0) {
                smallestEven = cur;
                break;
            }
        }

        return largestOdd - smallestEven;
    }
}
