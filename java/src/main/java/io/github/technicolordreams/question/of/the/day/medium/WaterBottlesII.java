package io.github.technicolordreams.question.of.the.day.medium;

/**
 * <h1><a href="https://leetcode.com/problems/water-bottles-ii/description/?envType=daily-question&envId=2025-10-02">3100. Water Bottles II</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-10-02</h3>
 */
public class WaterBottlesII {
    public static void main(String[] args) {
        System.out.println(solution(13, 6));
        System.out.println(solution(10, 3));
    }

    public static int solution(int numBottles, int numExchange) {
        int curFull = numBottles;
        int curEmpty = 0;
        int totalEmpty = 0;

        while (curFull > 0) {
            totalEmpty += curFull;
            curEmpty += curFull;
            curFull = 0;
            while (curEmpty >= numExchange) {
                curFull += 1;
                curEmpty -= numExchange;
                numExchange += 1;
            }
        }

        return totalEmpty;
    }
}
