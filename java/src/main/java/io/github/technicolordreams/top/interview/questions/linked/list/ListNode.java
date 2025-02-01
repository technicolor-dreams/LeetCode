package io.github.technicolordreams.top.interview.questions.linked.list;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    public ListNode(int[] arr) {
        this.val = arr[0];
        ListNode current = this;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }
}
