package io.github.technicolordreams.top.interview.questions.binary.tree.bfs.easy;

import io.github.technicolordreams.top.interview.questions.binary.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * <h1><a href="https://leetcode.com/problems/average-of-levels-in-binary-tree/description/">637. Average of Levels in Binary Tree</a></h1>
 * <h2>Easy</h2>
 * <h3>2025-02-06</h3>
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> solution(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            double curSum = 0;
            double curCount = 0;
            Stack<TreeNode> tempStack = new Stack<>();
            while (!stack.empty()) {
                TreeNode cur = stack.pop();
                curCount += 1;
                curSum += cur.val;
                if (Objects.nonNull(cur.left)) {
                    tempStack.push(cur.left);
                }

                if (Objects.nonNull(cur.right)) {
                    tempStack.push(cur.right);
                }
            }

            stack = tempStack;
            res.add(curSum / curCount);
        }

        return res;
    }
}
