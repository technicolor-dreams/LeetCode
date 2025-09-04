package io.github.technicolordreams.question.of.the.day.easy;

/**
 * <h1><a href="https://leetcode.com/problems/find-closest-person/description/">3516. Find Closest Person</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-09-04</h3>
 */
public class FindClosestPerson {
    public int solution(int x, int y, int z) {
        int xDist = Math.abs(z - x);
        int yDist = Math.abs(z - y);
        if (xDist == yDist) {
            return 0;
        } else if (xDist < yDist) {
            return 1;
        } else {
            return 2;
        }
    }
}
