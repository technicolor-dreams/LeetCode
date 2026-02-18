package io.github.technicolordreams.question.of.the.day.easy;

public class BinaryNumberWithAlternatingBits {
    public static void main(String[] args) {
        System.out.println(BinaryNumberWithAlternatingBits.solution(5));
        System.out.println(BinaryNumberWithAlternatingBits.solution(7));
        System.out.println(BinaryNumberWithAlternatingBits.solution(11));
    }

    public static boolean solution(int n) {
        int cur = n & 1;
        for (int i = 0; i < 32 & n > 0; i += 1) {
            n >>= 1;
            if (cur == (n & 1)) {
                return false;
            }

            cur = n & 1;
        }

        return true;
    }
}
