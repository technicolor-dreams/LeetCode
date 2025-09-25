package io.github.technicolordreams.question.of.the.day.medium;

/**
 * <h1><a href="https://leetcode.com/problems/fraction-to-recurring-decimal/description/?envType=daily-question&envId=2025-09-24">166. Fraction to Recurring Decimal</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-09-25</h3>
 */
public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        System.out.println(FractionToRecurringDecimal.solution(1, 2));
        System.out.println(FractionToRecurringDecimal.solution(2, 1));
        System.out.println(FractionToRecurringDecimal.solution(4, 333));
    }
    public static String solution(int numerator, int denominator) {
        return String.valueOf((float) numerator / (float) denominator);
    }
}
