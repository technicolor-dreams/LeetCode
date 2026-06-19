package io.github.technicolordreams.question.of.the.day.easy;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        System.out.println(FindTheHighestAltitude.solution(new int[]{-5, 1, 5, 0, -7}) == 1);
        System.out.println(FindTheHighestAltitude.solution(new int[]{-4, -3, -2, -1, 4, 3, 2}) == 0);
    }

    public static int solution(int[] gain) {
        int res = 0;
        int altitude = 0;
        for (int cur : gain) {
            altitude += cur;
            res = Math.max(res, altitude);
        }

        return res;
    }
}
