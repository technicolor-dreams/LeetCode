package io.github.technicolordreams.question.of.the.day.medium;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/maximum-matching-of-players-with-trainers/">2410. Maximum Matching of Players With Trainers</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-07-11</h3>
 */
public class MaximumMatchingOfPlayersWithTrainers {
    public static void main(String[] args) {
        MaximumMatchingOfPlayersWithTrainers a = new MaximumMatchingOfPlayersWithTrainers();

        System.out.println(a.solution(new int[]{4, 7, 9}, new int[]{8, 2, 5, 8}));
        System.out.println(a.solution(new int[]{1, 1, 1}, new int[]{10}));
    }

    public int solution(int[] players, int[] trainers) {

        Arrays.sort(players);
        Arrays.sort(trainers);

        int res = 0;
        int curPlayer = players.length - 1;
        int curTrainer = trainers.length - 1;

        while (curPlayer >= 0 && curTrainer >= 0) {
            if (players[curPlayer] <= trainers[curTrainer]) {
                res += 1;
                curTrainer -= 1;
            }
            curPlayer -= 1;
        }

        return res;
    }
}
