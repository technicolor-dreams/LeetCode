package io.github.technicolordreams.question.of.the.day.easy;

public class Largest3SameDigitNumberInString {
    public static void main(String[] args) {
        Largest3SameDigitNumberInString a = new Largest3SameDigitNumberInString();
        System.out.println(a.solution("6777133339"));
        System.out.println(a.solution("2300019"));
        System.out.println(a.solution("42352338"));
        System.out.println(a.solution("222"));
    }

    public String solution(String num) {
        int res = -1;
        for (int i = 0; i <= num.length() - 3;) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                res = Math.max(res, Integer.parseInt(String.valueOf(num.charAt(i))));
                i += 3;
            } else {
                i += 1;
            }
        }

        return res == -1 ? "" : String.format("%d%d%d", res, res, res);
    }
}
