package io.github.technicolordreams.question.of.the.day.medium;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/valid-sudoku/description/">36. Valid Sudoku</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-08-29</h3>
 */
public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku a = new ValidSudoku();

        char[][] board1 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] board2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(a.solution(board1));
        System.out.println(a.solution(board2));
    }

    public boolean solution(char[][] board) {
        boolean[] seen = new boolean[9];

        for (int i = 0; i < 9; i += 1) {
            Arrays.fill(seen, false);
            for (int j = 0; j < 9; j += 1) {
                char cur = board[i][j];
                if (cur == '.') {
                    continue;
                }

                int curInt = cur - '0';
                if (seen[curInt - 1]) {
                    return false;
                }

                seen[curInt - 1] = true;
            }
        }

        for (int i = 0; i < 9; i += 1) {
            Arrays.fill(seen, false);
            for (int j = 0; j < 9; j += 1) {
                char cur = board[j][i];
                if (cur == '.') {
                    continue;
                }

                int curInt = cur - '0';
                if (seen[curInt - 1]) {
                    return false;
                }

                seen[curInt - 1] = true;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(seen, false);
                for (int k = i; k < i + 3; k += 1) {
                    for(int l = j; l < j + 3; l += 1) {
                        char cur = board[k][l];
                        if (cur == '.') {
                            continue;
                        }

                        int curInt = cur - '0';
                        if (seen[curInt - 1]) {
                            return false;
                        }

                        seen[curInt - 1] = true;
                    }
                }
            }
        }

        return true;
    }
}
