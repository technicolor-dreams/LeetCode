package io.github.technicolordreams.top.interview.questions.binary.tree.general.medium;

import io.github.technicolordreams.top.interview.questions.binary.tree.general.TreeNode;

import java.util.*;

/**
 * <h1><a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description">114. Flatten Binary Tree to Linked List</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-01</h3>
 */
public class FlattenBinaryTreeToLinkedList {
    public void solution(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (Objects.nonNull(cur.right)) {
                stack.push(cur.right);
            }

            if (Objects.nonNull(cur.left)) {
                stack.push(cur.left);
            }
        }

        root.left = null;
        for (int i = 0; i < list.size(); i += 1) {
            root.val = list.get(i);
            if (i == list.size() - 1) {
                break;
            }

            root.right = new TreeNode();
            root = root.right;
        }
    }
}
