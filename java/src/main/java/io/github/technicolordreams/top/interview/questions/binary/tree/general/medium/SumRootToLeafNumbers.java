package io.github.technicolordreams.top.interview.questions.binary.tree.general.medium;

import io.github.technicolordreams.top.interview.questions.binary.tree.general.TreeNode;

import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * <h1><a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/description/">129. Sum Root to Leaf Numbers</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-02</h3>
 */
public class SumRootToLeafNumbers {
    public int solution(TreeNode root) {
        int res = 0;
        Stack<Map.Entry<TreeNode, StringBuilder>> stack = new Stack<>();
        stack.push(Map.entry(root, new StringBuilder(String.valueOf(root.val))));
        while (!stack.empty()) {
            Map.Entry<TreeNode, StringBuilder> cur = stack.pop();
            TreeNode curTreeNode = cur.getKey();
            StringBuilder curStringBuilder = cur.getValue();
            if (Objects.isNull(curTreeNode.left) && Objects.isNull(curTreeNode.right)) {
                res += Integer.parseInt(curStringBuilder.toString());
                continue;
            }

            if (Objects.nonNull(curTreeNode.left)) {
                StringBuilder stringBuilder = new StringBuilder(curStringBuilder.toString());
                stringBuilder.append(curTreeNode.left.val);
                stack.push(Map.entry(curTreeNode.left, stringBuilder));
            }

            if (Objects.nonNull(curTreeNode.right)) {
                StringBuilder stringBuilder = new StringBuilder(curStringBuilder.toString());
                stringBuilder.append(curTreeNode.right.val);
                stack.push(Map.entry(curTreeNode.right, stringBuilder));
            }
        }

        return res;
    }
}
