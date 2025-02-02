package io.github.technicolordreams.top.interview.questions.linked.list.medium;

import io.github.technicolordreams.top.interview.questions.linked.list.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <h1><a href="https://leetcode.com/problems/copy-list-with-random-pointer/description/">138. Copy List with Random Pointer</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-02</h3>
 */
public class CopyListWithRandomPointer {
    public Node solution(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }

        Node res = new Node(head.val);
        Node curRes = res;
        Map<Node, Node> map = new HashMap<>();
        map.put(head, res);
        Node cur = head.next;
        while (Objects.nonNull(cur)) {
            curRes.next = new Node(cur.val);
            curRes = curRes.next;
            map.put(cur, curRes);
            cur = cur.next;
        }

        cur = head;
        while (Objects.nonNull(cur)) {
            Node correspondingResNode = map.get(cur);
            correspondingResNode.random = map.get(cur.random);
            cur = cur.next;
        }

        return res;
    }
}
