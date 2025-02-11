package io.github.technicolordreams.question.of.the.day.medium;

/**
 * <h1><a href+"https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/">1910. Remove All Occurrences of a Substring</a></h1>
 * <h2
 */
public class RemoveAllOccurrencesOfASubstring {
    public static void main(String[] args) {
        RemoveAllOccurrencesOfASubstring a = new RemoveAllOccurrencesOfASubstring();
        System.out.println(a.solution("daabcbaabcbc", "abc"));
        System.out.println(a.solution("axxxxyyyyb", "xy"));
        System.out.println(a.solution("eemckxmckx", "emckx"));
        System.out.println(a.solution("ccctltctlltlb", "ctl"));
    }

    public String solution(String s, String part) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i += 1) {
            res.append(s.charAt(i));
            if (res.length() >= part.length()
                    && res.substring(res.length() - part.length(), res.length()).equals(part)) {
                res.delete(res.length() - part.length(), res.length());
            }
        }

        return res.toString();
    }
}
