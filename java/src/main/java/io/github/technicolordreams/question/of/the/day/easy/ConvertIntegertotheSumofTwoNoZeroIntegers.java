package io.github.technicolordreams.question.of.the.day.easy;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description">1317. Convert Integer to the Sum of Two No-Zero Integers</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-09-08</h3>
 */
public class ConvertIntegertotheSumofTwoNoZeroIntegers {
    public static void main(String[] args) {
        ConvertIntegertotheSumofTwoNoZeroIntegers a = new ConvertIntegertotheSumofTwoNoZeroIntegers();
        System.out.println(Arrays.toString(a.solution(2)));
        System.out.println(Arrays.toString(a.solution(11)));
    }

    public int[] solution(int n) {
        int a = n;
        int b = 0;
        while (String.valueOf(a).contains("0") || String.valueOf(b).contains("0")) {
            b += 1;
            a -= 1;
        }

        return new int[]{a, b};
    }
}
