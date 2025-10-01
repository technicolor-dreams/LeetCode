package io.github.technicolordreams.question.of.the.day.easy;

/**
 * <h1><a href="https://leetcode.com/problems/water-bottles/?envType=daily-question&envId=2025-10-01">1518. Water Bottles</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-10-01</h3>
 */
public class WaterBottles {
    public static void main(String[] args) {
        int result1 = solution(9, 3);
        System.out.println("numBottles = 9, numExchange = 3, Output: " + result1);

        int result2 = solution(15, 4);
        System.out.println("numBottles = 15, numExchange = 4, Output: " + result2);
    }

    public static int solution(int numBottles, int numExchange) {
        int curFull = numBottles;
        int curEmpty = 0;
        int totalEmpty = 0;

        while (curFull > 0) {
            totalEmpty += curFull;
            curEmpty += curFull;
            curFull = curEmpty / numExchange;
            curEmpty -= curFull * numExchange;
        }

        return totalEmpty;
    }
}
