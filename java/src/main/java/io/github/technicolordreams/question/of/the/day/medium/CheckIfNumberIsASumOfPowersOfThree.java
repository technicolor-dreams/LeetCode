package io.github.technicolordreams.question.of.the.day.medium;

/**
 * <h1><a href="https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/description/">1780. Check if Number is a Sum of Powers of Three</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-03-04</h3>
 */
public class CheckIfNumberIsASumOfPowersOfThree {
    public static void main(String[] args) {
        CheckIfNumberIsASumOfPowersOfThree a = new CheckIfNumberIsASumOfPowersOfThree();
        System.out.println(a.solution(12));
        System.out.println(a.solution(91));
        System.out.println(a.solution(21));
    }

    public boolean solution(int n) {
        return !Integer.toString(n, 3).contains("2");
    }
}
