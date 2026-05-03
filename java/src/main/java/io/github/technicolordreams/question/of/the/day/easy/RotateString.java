package io.github.technicolordreams.question.of.the.day.easy;

public class RotateString {
    public static void main(String[] args) {
        assert RotateString.solution("abcde", "bcdea");
        assert !RotateString.solution("abcde", "abced");
    }

    public static boolean solution(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        return (s + s).contains(goal);
    }
}
