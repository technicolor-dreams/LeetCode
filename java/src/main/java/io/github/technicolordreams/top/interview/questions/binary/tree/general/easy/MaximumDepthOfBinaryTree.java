package io.github.technicolordreams.top.interview.questions.binary.tree.general.easy;

import io.github.technicolordreams.top.interview.questions.binary.tree.general.TreeNode;

import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * <h1><a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/">104. Maximum Depth of Binary Tree</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-29</h3>
 */
public class MaximumDepthOfBinaryTree {
    public int solution(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        int res = 0;
        Stack<Map.Entry<TreeNode, Integer>> stack = new Stack<>();
        stack.push(Map.entry(root, 1));
        while (!stack.empty()) {
            Map.Entry<TreeNode, Integer> cur = stack.pop();

            int curDepth = cur.getValue();
            res = Math.max(res, curDepth);

            TreeNode curTreeNode = cur.getKey();
            if (Objects.nonNull(curTreeNode.left)) {
                stack.push(Map.entry(curTreeNode.left, curDepth + 1));
            }

            if (Objects.nonNull(curTreeNode.right)) {
                stack.push(Map.entry(curTreeNode.right, curDepth + 1));
            }
        }

        return res;
    }
}
