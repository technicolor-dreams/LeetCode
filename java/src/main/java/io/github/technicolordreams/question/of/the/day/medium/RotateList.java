package io.github.technicolordreams.question.of.the.day.medium;

import io.github.technicolordreams.data.structures.ListNode;

public class RotateList {
    public static void main(String[] args) {
        // [1,2,3,4,5], k=2 -> expected: [4,5,1,2,3]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result1 = solution(head1, 2);
        StringBuilder sb1 = new StringBuilder();
        for (ListNode n = result1; n != null; n = n.next) sb1.append(n.val).append("->");
        System.out.println("[1,2,3,4,5] k=2: " + sb1.toString().replaceAll("->$", "") + " (expected: 4->5->1->2->3)");

        // [0,1,2], k=4 -> expected: [2,0,1]
        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode result2 = solution(head2, 4);
        StringBuilder sb2 = new StringBuilder();
        for (ListNode n = result2; n != null; n = n.next) sb2.append(n.val).append("->");
        System.out.println("[0,1,2] k=4:     " + sb2.toString().replaceAll("->$", "") + " (expected: 2->0->1)");
    }

    public static ListNode solution(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int count = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        // Make circular
        cur.next = head;

        int skip = count - (k % count) - 1;
        cur = head;
        for (int i = 0; i < skip; i++) {
            cur = cur.next;
        }

        ListNode res = cur.next;
        cur.next = null;
        return res;
    }
}
