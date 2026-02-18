package io.github.technicolordreams.question.of.the.day.easy;

public class ReverseBits {
    public static void main(String[] args) {
        // LeetCode examples
        System.out.println(ReverseBits.solution(43261596));     // 00000010100101000001111010011100 -> 964176192
        System.out.println(ReverseBits.solution(2147483644));   // 01111111111111111111111111111100 -> 00111111111111111111111111111110 = 1073741823

        // Powers of two
        System.out.println(ReverseBits.solution(1));            // 00...001 -> 10...000 = -2147483648
        System.out.println(ReverseBits.solution(2));            // 00...010 -> 01...000 = 1073741824
        System.out.println(ReverseBits.solution(Integer.MIN_VALUE)); // 10000...0 -> 00...001 = 1

        // All bits set / zero
        System.out.println(ReverseBits.solution(-1));           // 11111111111111111111111111111111 -> -1
        System.out.println(ReverseBits.solution(0));            // 00...000 -> 0

        // Palindrome bits (should be symmetric)
        System.out.println(ReverseBits.solution(0b01111111111111111111111111111110)); // -> same value reversed
        System.out.println(ReverseBits.solution(0b00000000000000000000000000000001)); // 1 -> Integer.MIN_VALUE (if 32-bit)
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
