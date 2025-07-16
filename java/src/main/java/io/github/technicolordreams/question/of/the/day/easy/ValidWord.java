package io.github.technicolordreams.question.of.the.day.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1><a href="https://leetcode.com/problems/valid-word/description/">3136. Valid Word</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-07-15</h3>
 */
public class ValidWord {
    public static void main(String[] args) {
        ValidWord a = new ValidWord();
        System.out.println(a.solution("234Adas"));
        System.out.println(a.solution("b3"));
        System.out.println(a.solution("a3$e"));
        System.out.println(a.solution("Ya$"));
    }

    public boolean solution(String word) {
        if (word.length() < 3) {
            return false;
        }

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> consonants =
                Set.of('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z');
        Set<Character> digits = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (char c : word.toLowerCase().toCharArray()) {
            if (vowels.contains(c)) {
                hasVowel = true;
                continue;
            } else if (consonants.contains(c)) {
                hasConsonant = true;
                continue;
            } else if (digits.contains(c)) {
                continue;
            }

            return false;
        }

        return hasConsonant && hasVowel;
    }
}
