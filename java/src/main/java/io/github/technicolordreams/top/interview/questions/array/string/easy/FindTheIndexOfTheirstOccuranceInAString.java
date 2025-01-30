package io.github.technicolordreams.top.interview.questions.array.string.easy;

/**
 * <h1><a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/">28. Find the Index of the First Occurrence in a String</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-30</h3>
 */
public class FindTheIndexOfTheirstOccuranceInAString {
    public int solution(String haystack, String needle) {
        return !haystack.contains(needle) ? -1 : haystack.indexOf(needle);
    }
}
