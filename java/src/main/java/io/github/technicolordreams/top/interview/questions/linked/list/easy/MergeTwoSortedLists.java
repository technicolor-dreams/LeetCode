package io.github.technicolordreams.top.interview.questions.linked.list.easy;

import io.github.technicolordreams.top.interview.questions.linked.list.ListNode;

import java.util.Objects;

/**
 * <h1><a href="https://leetcode.com/problems/merge-two-sorted-lists/description/">21. Merge Two Sorted Lists</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-02-01</h3>
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        System.out.println(mergeTwoSortedLists.solution(
                new ListNode(new int[]{1, 2, 4}),
                new ListNode(new int[]{1, 3, 4})));
    }

    public ListNode solution(ListNode list1, ListNode list2) {
        if (Objects.isNull(list1) && Objects.isNull(list2)) {
            return null;
        }

        if (Objects.isNull(list1)) {
            return list2;
        }

        if (Objects.isNull(list2)) {
            return list1;
        }

        ListNode res;
        ListNode cur1;
        ListNode cur2;
        if (list1.val < list2.val) {
            res = list1;
            cur1 = list1.next;
            cur2 = list2;
        } else {
            res = list2;
            cur1 = list1;
            cur2 = list2.next;
        }

        ListNode curRes = res;

        while (Objects.nonNull(cur1) || Objects.nonNull(cur2)) {
            if (Objects.isNull(cur1)) {
                curRes.next = cur2;
                return res;
            }

            if (Objects.isNull(cur2)) {
                curRes.next = cur1;
                return res;
            }

            if (cur1.val < cur2.val) {
                curRes.next = cur1;
                cur1 = cur1.next;
            } else {
                curRes.next = cur2;
                cur2 = cur2.next;
            }

            curRes = curRes.next;
        }

        return res;
    }
}
