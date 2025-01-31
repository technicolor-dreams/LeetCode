package io.github.technicolordreams.top.interview.questions.binary.tree.general.easy;

import io.github.technicolordreams.top.interview.questions.binary.tree.general.TreeNode;

import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * <h1><a href="https://leetcode.com/problems/path-sum/description/">112. Path Sum</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-01-31</h3>
 */
public class PathSum {
    public boolean solution(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return false;
        }

        Stack<Map.Entry<TreeNode, Integer>> stack = new Stack<>();
        stack.push(Map.entry(root, root.val));
        while (!stack.empty()) {
            Map.Entry<TreeNode, Integer> cur = stack.pop();
            TreeNode curTreeNode = cur.getKey();
            Integer curSum = cur.getValue();

            TreeNode curLeft = curTreeNode.left;
            TreeNode curRight = curTreeNode.right;

            System.out.printf("curVal: %d curSum: %d%n", curTreeNode.val, curSum);

            if (Objects.isNull(curLeft) && Objects.isNull(curRight)) {
                if (curSum == targetSum) {
                    return true;
                }

                continue;
            }

            if (Objects.nonNull(curLeft)) {
                stack.push(Map.entry(curLeft, curSum + curLeft.val));
            }

            if (Objects.nonNull(curRight)) {
                stack.push(Map.entry(curRight, curSum + curRight.val));
            }
        }

        return false;
    }
}
