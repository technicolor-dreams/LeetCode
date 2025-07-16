package io.github.technicolordreams.question.of.the.day.medium;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <h1><a href="https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/description/">3201. Find the Maximum Length of Valid Subsequence I</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-07-15</h3>
 */
public class FindTheMaximumLengthOfValidSubsequenceI {
    public static void main(String[] args) {
        FindTheMaximumLengthOfValidSubsequenceI a = new FindTheMaximumLengthOfValidSubsequenceI();
        System.out.println(a.solution(new int[]{1,2,3,4}));
        System.out.println(a.solution(new int[]{1,2,1,1,2,1,2}));
        System.out.println(a.solution(new int[]{1,3}));
    }

    public int solution(int[] nums) {

        int oddCount = (int) Arrays.stream(nums).filter(num -> num % 2 == 1).count();
        int eventCount = (int) Arrays.stream(nums).filter(num -> num % 2 == 0).count();

        int startEven = 0;
        boolean nextEven = true;
        for (int num : nums) {
            if (num % 2 == (nextEven ? 0 : 1)) {
                startEven += 1;
                nextEven = !nextEven;
            }
        }

        int startOdd = 0;
        nextEven = false;
        for (int num : nums) {
            if (num % 2 == (nextEven ? 0 : 1)) {
                startOdd += 1;
                nextEven = !nextEven;
            }
        }

        return IntStream.of(oddCount, eventCount, startEven, startOdd).max().getAsInt();
    }
}
