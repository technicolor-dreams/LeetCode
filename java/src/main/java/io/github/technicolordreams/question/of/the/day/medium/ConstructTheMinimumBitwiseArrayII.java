package io.github.technicolordreams.question.of.the.day.medium;

import java.util.Arrays;
import java.util.List;

public class ConstructTheMinimumBitwiseArrayII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(ConstructTheMinimumBitwiseArrayII.solution(List.of(2, 3, 5, 7))));
        System.out.println(Arrays.toString(ConstructTheMinimumBitwiseArrayII.solution(List.of(11, 13, 31))));
    }

    public static int[] solution(List<Integer> nums) {
        int[] res = new int[nums.size()];
        for (int i = 0; i < res.length; i += 1) {
            int curNum = nums.get(i);
            int k = Integer.numberOfTrailingZeros(~curNum);
            if (k == 0) {
                res[i] = -1;
                continue;
            }

            int lower = (int) (curNum - Math.pow(2, k) + 1);
            int upper = curNum - 1;
            for (int j = lower; j <= upper; j += 1) {
                if ((j | (j + 1)) == curNum) {
                    res[i] = j;
                    break;
                }
            }
        }

        return res;
    }
}
