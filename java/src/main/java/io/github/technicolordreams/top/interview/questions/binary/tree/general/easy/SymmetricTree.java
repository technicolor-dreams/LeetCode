package io.github.technicolordreams.top.interview.questions.binary.tree.general.easy;

import io.github.technicolordreams.top.interview.questions.binary.tree.general.TreeNode;

import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * <h1><a href="https://leetcode.com/problems/symmetric-tree/description/">101. Symmetric Tree</a></h1>
 * <h2>Easy</h2>
 * <h3>2024-01-31</h3>
 */
public class SymmetricTree {
    public boolean solution(TreeNode root) {
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return true;
        }

        if (Objects.isNull(root.left) || Objects.isNull(root.right)) {
            return false;
        }

        return this.isSameTree(root.left, this.invertBinaryTree(root.right));
    }

    private TreeNode invertBinaryTree(TreeNode root) {
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

    private boolean isSameTree(TreeNode p, TreeNode q) {
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
