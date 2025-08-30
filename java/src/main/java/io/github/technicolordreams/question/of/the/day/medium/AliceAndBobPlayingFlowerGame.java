package io.github.technicolordreams.question.of.the.day.medium;

/**
 * <h1><a href="https://leetcode.com/problems/alice-and-bob-playing-flower-game/">3021. Alice and Bob Playing Flower Game</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-08-29</h3>
 */
public class AliceAndBobPlayingFlowerGame {
    public static void main(String[] args) {

        AliceAndBobPlayingFlowerGame a = new AliceAndBobPlayingFlowerGame();
        System.out.println(a.solution(3, 2));
        System.out.println(a.solution(1, 1));
    }

    public long solution(int n, int m) {
        long nEven = n / 2;
        long nOdd = (n + 1) / 2;

        long mEven = m / 2;
        long mOdd = (m + 1) / 2;

        return nEven * mOdd + nOdd * mEven;
    }
}
