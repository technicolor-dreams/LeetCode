package io.github.technicolordreams.question.of.the.day.easy;

public class PowerOfTwo {
    public static void main(String[] args) {
        // Powers of two (expect true)
        System.out.println(PowerOfTwo.solution(1));    // 2^0 = 1  -> true
        System.out.println(PowerOfTwo.solution(2));    // 2^1 = 2  -> true
        System.out.println(PowerOfTwo.solution(4));    // 2^2 = 4  -> true
        System.out.println(PowerOfTwo.solution(8));    // 2^3 = 8  -> true
        System.out.println(PowerOfTwo.solution(16));   // 2^4 = 16 -> true
        System.out.println(PowerOfTwo.solution(1024)); // 2^10     -> true

        // Not powers of two (expect false)
        System.out.println(PowerOfTwo.solution(0));    // 0        -> false
        System.out.println(PowerOfTwo.solution(3));    // 3        -> false
        System.out.println(PowerOfTwo.solution(5));    // 5        -> false
        System.out.println(PowerOfTwo.solution(6));    // 6        -> false
        System.out.println(PowerOfTwo.solution(7));    // 7        -> false
        System.out.println(PowerOfTwo.solution(100));  // 100      -> false

        // Edge cases
        System.out.println(PowerOfTwo.solution(Integer.MAX_VALUE));       // 2^31 - 1 -> false
        System.out.println(PowerOfTwo.solution(Integer.MIN_VALUE));       // -2^31    -> false
        System.out.println(PowerOfTwo.solution(1073741824)); // 2^30      -> true
    }

    public static boolean solution(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count += 1;
            }

            n >>= 1;
        }

        return count == 1;
    }
}
