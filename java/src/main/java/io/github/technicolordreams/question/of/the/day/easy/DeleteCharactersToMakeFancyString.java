package io.github.technicolordreams.question.of.the.day.easy;

/**
 * <h1><a href="https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/">1957. Delete Characters to Make Fancy String</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-07-21</h3>
 */
public class DeleteCharactersToMakeFancyString {
    public static void main(String[] args) {
        DeleteCharactersToMakeFancyString a = new DeleteCharactersToMakeFancyString();
        System.out.println(a.solution("leeetcode"));
        System.out.println(a.solution("aaabaaaa"));
        System.out.println(a.solution("aab"));
    }

    public String solution(String s) {
        char curDup = s.charAt(0);
        int dupCount = 1;
        StringBuilder res = new StringBuilder(String.valueOf(curDup));
        for (int i = 1; i < s.length(); i += 1) {
            char cur = s.charAt(i);
            if (curDup == cur) {
                dupCount += 1;
                if (dupCount <= 2) {
                    res.append(cur);
                }
            } else {
                res.append(cur);
                curDup = cur;
                dupCount = 1;
            }
        }

        return res.toString();
    }
}
