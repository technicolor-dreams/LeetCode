package io.github.technicolordreams.question.of.the.day.easy;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        System.out.println(FindSmallestLetterGreaterThanTarget.solution(new char[]{'c','f','j'}, 'a'));
        System.out.println(FindSmallestLetterGreaterThanTarget.solution(new char[]{'c','f','j'}, 'c'));
        System.out.println(FindSmallestLetterGreaterThanTarget.solution(new char[]{'x', 'x','y','y'}, 'z'));
    }

    public static char solution(char[] letters, char target) {
        for (char letter: letters) {
            if (target < letter) {
                return letter;
            }
        }

        return letters[0];
    }
}
