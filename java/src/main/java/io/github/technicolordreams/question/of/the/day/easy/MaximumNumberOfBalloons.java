package io.github.technicolordreams.question.of.the.day.easy;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {
    public static void main(String[] args) {
        System.out.println(MaximumNumberOfBalloons.solution("nlaebolko") == 1);
        System.out.println(MaximumNumberOfBalloons.solution("loonbalxballpoon") == 2);
        System.out.println(MaximumNumberOfBalloons.solution("leetcode") == 0);
        System.out.println(MaximumNumberOfBalloons.solution("ballon") == 0);
    }

    public static int solution(String text) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : "balloon".toCharArray()) {
            charCountMap.put(c, 0);
        }

        for (char c : text.toCharArray()) {
            charCountMap.computeIfPresent(c, (k, v) -> v + 1);
        }

        charCountMap.computeIfPresent('l', (k, v) -> Math.floorDiv(v, 2));
        charCountMap.computeIfPresent('o', (k, v) -> Math.floorDiv(v, 2));

        return charCountMap.values().stream().min(Integer::compareTo).orElse(0);
    }
}
