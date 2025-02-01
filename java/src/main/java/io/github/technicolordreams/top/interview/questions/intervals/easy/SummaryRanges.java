package io.github.technicolordreams.top.interview.questions.intervals.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * <h1><a href="https://leetcode.com/problems/summary-ranges/description/">228. Summary Ranges</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-02-01</h3>
 */
public class SummaryRanges {
    public List<String> solution(int[] nums) {
        List<String> res = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int num : nums) {
            if (!linkedList.isEmpty() && num - linkedList.getLast() != 1) {
                if (!Objects.equals(linkedList.getFirst(), linkedList.getLast())) {
                    res.add(linkedList.getFirst() + "->" + linkedList.getLast());
                } else {
                    res.add(String.valueOf(linkedList.getFirst()));
                }

                linkedList.clear();
            }

            linkedList.add(num);
        }

        if (!linkedList.isEmpty()) {
            if (!Objects.equals(linkedList.getFirst(), linkedList.getLast())) {
                res.add(linkedList.getFirst() + "->" + linkedList.getLast());
            } else {
                res.add(String.valueOf(linkedList.getFirst()));
            }

            linkedList.clear();
        }

        return res;
    }
}
