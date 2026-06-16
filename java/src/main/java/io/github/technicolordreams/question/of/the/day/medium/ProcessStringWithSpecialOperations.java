package io.github.technicolordreams.question.of.the.day.medium;

import java.util.LinkedList;

public class ProcessStringWithSpecialOperations {
    public static void main(String[] args) {
        System.out.println(ProcessStringWithSpecialOperations.solution("a#b%*").equals("ba"));
        System.out.println(ProcessStringWithSpecialOperations.solution("z*#").equals(""));
    }

    public static String solution(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*' ) {
                if (!res.isEmpty()) {
                    res.deleteCharAt(res.length() - 1);
                }
            } else if (c == '#') {
                res.append(res);
            } else if (c == '%') {
                res.reverse();
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}
