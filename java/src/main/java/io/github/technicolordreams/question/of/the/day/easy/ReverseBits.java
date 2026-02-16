package io.github.technicolordreams.question.of.the.day.easy;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(ReverseBits.solution(43261596));
        System.out.println(ReverseBits.solution(2147483644));
    }

    public static int solution(int n) {
        int res = 0;
        for (int ignore = 0; ignore < 32; ignore += 1) {
            res <<= 1;
            res |= n & 1;
            n >>= 1;
        }

        return res;
    }
}
