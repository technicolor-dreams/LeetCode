package io.github.technicolordreams.top.interview.questions.linked.list.medium;

import io.github.technicolordreams.top.interview.questions.linked.list.ListNode;

import java.util.Objects;
import java.util.Optional;

/**
 * <h1><a href="https://leetcode.com/problems/add-two-numbers/description/">2. Add Two Numbers</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-01</h3>
 */
public class AddTwoNumbers {
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode listNodeValZero = new ListNode(0);

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int curSum = cur1.val + cur2.val;
        int carryOver = curSum > 10 ? 1 : 0;
        ListNode res = new ListNode(carryOver == 0 ? curSum : curSum - 10);
        ListNode curRes = res;
        cur1 = cur1.next;
        cur2 = cur2.next;
        while (Objects.nonNull(cur1) || Objects.nonNull(cur2)) {
            cur1 = Optional.ofNullable(cur1).orElse(listNodeValZero);
            cur2 = Optional.ofNullable(cur2).orElse(listNodeValZero);
            curSum = cur1.val + cur2.val + carryOver;
            carryOver = curSum >= 10 ? 1 : 0;
            curRes.next = new ListNode(carryOver == 0 ? curSum : curSum - 10);
            curRes = curRes.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        if (carryOver == 1) {
            curRes.next = new ListNode(1);
        }

        return res;
    }
}
