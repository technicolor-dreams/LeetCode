package io.github.technicolordreams.top.interview.questions.binary.tree.general;

import java.util.Objects;
import java.util.Stack;

/**
 * <h1><a href="https://leetcode.com/problems/invert-binary-tree/description/">226. Invert Binary Tree</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-29</h3>
 */
public class InvertBinaryTree {
    public TreeNode solution(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            TreeNode curLeft = cur.left;
            TreeNode curRight = cur.right;
            cur.left = curRight;
            cur.right = curLeft;
            if (Objects.nonNull(curLeft)) {
                stack.push(curLeft);
            }

            if (Objects.nonNull(curRight)) {
                stack.push(curRight);
            }
        }

        return root;
    }
}
