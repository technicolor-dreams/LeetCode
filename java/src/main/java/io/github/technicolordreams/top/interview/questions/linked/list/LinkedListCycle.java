package io.github.technicolordreams.top.interview.questions.linked.list;

import java.util.Objects;

public class LinkedListCycle {
    public boolean solution(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (Objects.nonNull(slow) && Objects.nonNull(fast)) {
            slow = slow.next;
            fast = fast.next;
            if (Objects.isNull(fast)) {
                break;
            }

            fast = fast.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
