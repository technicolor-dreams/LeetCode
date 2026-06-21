package io.github.technicolordreams.question.of.the.day.medium;

import java.util.Arrays;

public class MaximumIceCreamBars {
    public static void main(String[] args) {
        System.out.println(MaximumIceCreamBars.solution(new int[]{1,3,2,4,1}, 7));
        System.out.println(MaximumIceCreamBars.solution(new int[]{10,6,8,7,7,8}, 5));
        System.out.println(MaximumIceCreamBars.solution(new int[]{1,6,3,1,2,5}, 20));
    }

    public static int solution(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int cost : costs) {
            if (cost > coins) {
                return res;
            }

            coins -= cost;
            res += 1;
        }

        return res;
    }
}
