package io.github.technicolordreams.top.interview.questions.linked.list.medium;

import io.github.technicolordreams.top.interview.questions.linked.list.ListNode;

import java.util.Objects;

/**
 * <h1><a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/">19. Remove Nth Node From End of List</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-02</h3>
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        System.out.println(removeNthNodeFromEndOfList.solution(new ListNode(new int[]{1,2}), 1));
    }
    public ListNode solution(ListNode head, int n) {
        int length = 0;
        ListNode cur = head;
        while (Objects.nonNull(cur)) {
            length += 1;
            cur = cur.next;
        }

        if (length == n) {
            if (n == 1) {
                return null;
            }

            return head.next;
        }

        int remove = length - n + 1;
        cur = head;
        for (int i = 1; i < remove - 1; i += 1) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return head;
    }
}
