package io.github.technicolordreams.top.interview.questions.math.easy;

import java.sql.Array;
import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/plus-one/description/">66. Plus One</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-02-05</h3>
 */
public class PlusOne {
    public static void main(String[] args) {
        PlusOne a = new PlusOne();
        a.solution(new int[]{9,9,9});
    }

    public int[] solution(int[] digits) {
        int carryOver = 1;
        for (int i = digits.length - 1; i >= 0; i -= 1) {
            if (carryOver == 0) {
                break;
            }

            digits[i] += carryOver;
            if (digits[i] > 9) {
                digits[i] -= 10;
            } else {
                carryOver = 0;
            }
        }

        if (carryOver == 1) {
            int[] res = new int[digits.length + 1];
            Arrays.fill(res, 0);
            res[0] = carryOver;
            return res;
        }

        return digits;
    }
}
