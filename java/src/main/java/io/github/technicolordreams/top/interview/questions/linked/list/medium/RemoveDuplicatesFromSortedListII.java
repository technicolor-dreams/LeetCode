package io.github.technicolordreams.top.interview.questions.linked.list.medium;

import io.github.technicolordreams.top.interview.questions.linked.list.ListNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * <h1><a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/">2. Remove Duplicates from Sorted List II</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-04</h3>
 * <h4>10:53</h4>
 */
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII a = new RemoveDuplicatesFromSortedListII();
        System.out.println(a.solution(new ListNode(new int[]{1, 2, 3, 3, 4, 4, 5})));
        System.out.println(a.solution(new ListNode(new int[]{1, 1, 1, 2, 3})));
    }

    public ListNode solution(ListNode head) {
        Set<Integer> dups = new HashSet<>();
        ListNode cur = head;
        while (Objects.nonNull(cur)) {
            if (Objects.nonNull(cur.next) && cur.val == cur.next.val) {
                dups.add(cur.val);
                cur = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        cur = head;
        while (Objects.nonNull(cur) && dups.contains(cur.val)) {
            cur = cur.next;
        }

        ListNode res = cur;

        while (Objects.nonNull(cur)) {
            if (Objects.nonNull(cur.next)) {
                ListNode next = cur.next;
                while (Objects.nonNull(next) && dups.contains(next.val)) {
                    next = next.next;
                }

                cur.next = next;
            }

            cur = cur.next;
        }

        return res;
    }
}
