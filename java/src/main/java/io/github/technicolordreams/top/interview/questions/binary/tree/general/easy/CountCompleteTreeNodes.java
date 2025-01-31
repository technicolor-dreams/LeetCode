package io.github.technicolordreams.top.interview.questions.binary.tree.general.easy;

import io.github.technicolordreams.top.interview.questions.binary.tree.general.TreeNode;

import java.util.Objects;
import java.util.Stack;

/**
 * <h1><a href="https://leetcode.com/problems/count-complete-tree-nodes/description/">222. Count Complete Tree Nodes</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-31</h3>
 */
public class CountCompleteTreeNodes {
    public int solution(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            res += 1;
            if (Objects.nonNull(cur.left)) {
                stack.push(cur.left);
            }

            if (Objects.nonNull(cur.right)) {
                stack.push(cur.right);
            }
        }

        return res;
    }
}
