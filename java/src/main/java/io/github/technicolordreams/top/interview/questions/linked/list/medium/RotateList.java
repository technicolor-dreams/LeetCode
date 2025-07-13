package io.github.technicolordreams.top.interview.questions.linked.list.medium;

import io.github.technicolordreams.top.interview.questions.linked.list.ListNode;

import java.util.Objects;

/**
 * <h1><a href="https://leetcode.com/problems/rotate-list/description/">61. Rotate List</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-07</h3>
 */
public class RotateList {
    public static void main(String[] args) {
        RotateList a = new RotateList();
        System.out.println(a.solution(new ListNode(new int[]{1,2,3,4,5}), 2));
        System.out.println(a.solution(new ListNode(new int[]{0,1,2}), 4));
        System.out.println(a.solution(new ListNode(new int[]{1,2}), 1));
    }

    public ListNode solution(ListNode head, int k) {
        if (Objects.isNull(head) || k == 0) {
            return head;
        }

        int count = 1;
        ListNode cur = head;
        while (Objects.nonNull(cur.next)) {
            cur = cur.next;
            count += 1;
        }

        if (count == 1) {
            return head;
        }

        ListNode last = cur;
        last.next = head;
        cur = head;
        for (int i = 0; i < k; i += 1) {
            cur = cur.next;
        }

        ListNode res = cur;
        cur.next = null;
        last.next = head;

        return res;
    }
}
