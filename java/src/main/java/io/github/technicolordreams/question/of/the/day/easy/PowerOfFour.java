package io.github.technicolordreams.question.of.the.day.easy;

/**
 * <a href="https://leetcode.com/problems/power-of-four">343. Power of Four</a>
 */
public class PowerOfFour {
    public static void main(String[] args) {
        PowerOfFour a = new PowerOfFour();
//        System.out.println(a.solution(16));
//        System.out.println(a.solution(5));
//        System.out.println(a.solution(1));
        System.out.println(a.solution(-2147483648));
    }

    public boolean solution(int n) {
        if (n < 1) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 4 != 0) {
            return false;
        }

        int temp = n;
        while (temp != 1) {
            if (temp % 4 != 0) {
                return false;
            }

            temp = temp / 4;
        }

        return true;
    }
}
