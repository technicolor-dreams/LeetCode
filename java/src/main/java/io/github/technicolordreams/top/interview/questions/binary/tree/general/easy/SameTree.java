package io.github.technicolordreams.top.interview.questions.binary.tree.general.easy;

import io.github.technicolordreams.top.interview.questions.binary.tree.TreeNode;

import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * <h1><a href="https://leetcode.com/problems/same-tree/description/">100. Same Tree</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-29</h3>
 */
public class SameTree {
    public boolean solution(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        }

        if (Objects.isNull(p) || Objects.isNull(q)) {
            return false;
        }

        Stack<Map.Entry<TreeNode, TreeNode>> stack = new Stack<>();
        stack.push(Map.entry(p, q));
        while (!stack.empty()) {
            Map.Entry<TreeNode, TreeNode> cur = stack.pop();
            TreeNode curP = cur.getKey();
            TreeNode curQ = cur.getValue();
            if (curP.val != curQ.val) {
                return false;
            }

            if (Objects.nonNull(curP.left) && Objects.nonNull(curQ.left)) {
                stack.push(Map.entry(curP.left, curQ.left));
            } else if (Objects.nonNull(curP.left) || Objects.nonNull(curQ.left)) {
                return false;
            }

            if (Objects.nonNull(curP.right) && Objects.nonNull(curQ.right)) {
                stack.push(Map.entry(curP.right, curQ.right));
            } else if (Objects.nonNull(curP.right) || Objects.nonNull(curQ.right)) {
                return false;
            }
        }

        return true;
    }
}
