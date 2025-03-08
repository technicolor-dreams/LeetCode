package io.github.technicolordreams.question.of.the.day.easy;

/**
 * <h1><a href="https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/">2379. Minimum Recolors to Get K Consecutive Black Blocks</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-03-08</h3>
 * <h4>Time taken: 5 m 42 s</h4>
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public static void main(String[] args) {
        MinimumRecolorsToGetKConsecutiveBlackBlocks a = new MinimumRecolorsToGetKConsecutiveBlackBlocks();
        System.out.println(a.solution("WBBWWBBWBW", 7));
        System.out.println(a.solution("WBWBBBW", 2));
        System.out.println(a.solution("BWWWBB", 6));
    }

    public int solution(String blocks, int k) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < blocks.length() - k + 1; i += 1) {
            int whiteCount = 0;
            for (int j = i; j < i + k; j += 1) {
                if (blocks.charAt(j) == 'W') {
                    whiteCount += 1;
                }
            }

            res = Math.min(res, whiteCount);
        }

        return res;
    }
}
