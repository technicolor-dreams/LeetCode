package io.github.technicolordreams.question.of.the.day.easy;

/**
 * <h1><a href="https://leetcode.com/problems/count-good-triplets/">1534. Count Good Triplets</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-04-14</h3>
 */
public class CountGoodTriplets {
    public static void main(String[] args) {
        CountGoodTriplets a = new CountGoodTriplets();
        System.out.println(a.solution(new int[]{3,0,1,1,9,7}, 7, 2, 3));
        System.out.println(a.solution(new int[]{1,1,2,2,3}, 0, 0, 1));
    }

    public int solution(int[] arr, int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < arr.length; i += 1) {
            for (int j = i + 1; j < arr.length; j += 1) {
                for (int k = j + 1; k < arr.length; k += 1) {
                    if (Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        res += 1;
                    }
                }
            }
        }

        return res;
    }
}
