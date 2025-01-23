package io.github.technicolordreams.top.interview.questions.two.pointers;

import java.util.stream.Collectors;

/**
 * <h1><a href="https://leetcode.com/problems/valid-palindrome/description/">125. Valid Palindrome</a></h1>
 * <h2>Easy</h2>
 * <h3>2024-01-23</h3>
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(ValidPalindrome.solution(" "));
        System.out.println(ValidPalindrome.solution("race a car"));
        System.out.println(ValidPalindrome.solution("A man, a plan, a canal: Panama"));
    }

    public static boolean solution(String s) {
        String preprocessed =
                s.toLowerCase()
                        .chars()
                        .mapToObj(c -> (char) c)
                        .filter(Character::isLetterOrDigit)
                        .map(String::valueOf)
                        .collect(Collectors.joining());

        int i = 0;
        int j = preprocessed.length() - 1;
        while (i < j) {
            if (preprocessed.charAt(i) != preprocessed.charAt(j)) {
                return false;
            }

            i += 1;
            j -= 1;
        }

        return true;
    }
}
