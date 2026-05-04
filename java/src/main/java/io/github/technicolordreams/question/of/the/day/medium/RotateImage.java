package io.github.technicolordreams.question.of.the.day.medium;

public class RotateImage {
    public static void main(String[] args) {
        solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        solution(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
    }

    public static void solution(int[][] matrix) {
        for (int i = 0; i < matrix.length; i += 1) {
            for (int j = 0; j < i; j += 1) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i += 1) {
            for (int j = 0; j < Math.ceil((double) matrix.length / 2); j += 1) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
