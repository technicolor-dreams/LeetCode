package io.github.technicolordreams.question.of.the.day.easy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h1><a href="https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/">1790. Check if One String Swap Can Make Strings Equal</a></h1>
 * <h2>Easy</h2>
 * <h3>2024-02-05</h3>
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        CheckIfOneStringSwapCanMakeStringsEqual a = new CheckIfOneStringSwapCanMakeStringsEqual();
//        a.solution("bank", "kanb");
        a.solution("qgqeg", "gqgeq");
    }
    public boolean solution(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Map<String, Integer> diff = new HashMap<>();
        for (int i = 0; i < s1.length(); i += 1) {
            if (s1Array[i] == s2Array[i]) {
                continue;
            }

            String key = String.format("%c%c", s1Array[i], s2Array[i]);
            diff.putIfAbsent(key, 0);
            diff.computeIfPresent(key, (k, v) -> v + 1);
            if (diff.get(key) > 1) {
                return false;
            }
        }

        if (diff.isEmpty()) {
            return true;
        }

        if (diff.size() != 2) {
            return false;
        }

        return String.join("", diff.keySet().stream().toList())
                .chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .distinct()
                .toList()
                .size() == 2;
    }
}
