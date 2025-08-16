package io.github.technicolordreams.question.of.the.day.easy;

/**
 * <a href="https://leetcode.com/problems/maximum-69-number/">1323. Maximum 69 Number</a>
 */
public class Maximum69Number {
    public static void main(String[] args) {
        Maximum69Number a = new Maximum69Number();
        System.out.println(a.solution(9669));
        System.out.println(a.solution(9996));
        System.out.println(a.solution(9999));
    }

    public int solution(int num) {
        int max = num;
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length(); i += 1) {
            char[] numChars = String.valueOf(num).toCharArray();
            numChars[i] = numChars[i] == '6' ? '9' : '6';
            max = Math.max(max, Integer.parseInt(String.valueOf(numChars)));
        }

        return max;
    }
}
