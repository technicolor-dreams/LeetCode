package io.github.technicolordreams.question.of.the.day.medium;

public class AngleBetweenHandsOfAClock {
    public static void main(String[] args) {
        System.out.println(AngleBetweenHandsOfAClock.solution(12, 30));
        System.out.println(AngleBetweenHandsOfAClock.solution(3, 30));
        System.out.println(AngleBetweenHandsOfAClock.solution(3, 15));
    }

    public static double solution(int hour, int minutes) {
        if (hour == 12) {
            hour = 0;
        }

        double minutesRatio = minutes / 60.0 * 360;
        double hourRatio = hour * 30 + minutes * 0.5;
        double diff = Math.abs(minutesRatio - hourRatio);
        return Math.min(diff, 360 - diff); // smallest angle between the hands
    }
}
