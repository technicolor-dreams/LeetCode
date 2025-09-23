package io.github.technicolordreams.question.of.the.day.medium;

/**
 * <h1><a href="https://leetcode.com/problems/number-of-people-aware-of-a-secret/description/">2327. Number of People Aware of a Secret</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-09-09</h3>
 */
public class NumberOfPeopleAwareOfSecret {
    public static void main(String[] args) {
        NumberOfPeopleAwareOfSecret a = new NumberOfPeopleAwareOfSecret();
        System.out.println(a.solution(6, 2, 4));
        System.out.println(a.solution(4, 1, 3));
    }
    public int solution(int n, int delay, int forget) {
        int[][] know = new int[n + 1][2];
        know[1][1] = 1;
        for (int i = 2; i <= n; i += 1) {
            if (i - delay > 0) {

            }
        }

        int res = 0;
        for (int[] k : know) {
            res += k[1];
        }

        return res;
    }
}
