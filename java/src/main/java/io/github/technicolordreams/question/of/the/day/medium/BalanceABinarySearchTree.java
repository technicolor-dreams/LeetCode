package io.github.technicolordreams.question.of.the.day.medium;

import io.github.technicolordreams.data.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
    public TreeNode solution(TreeNode root) {
        List<TreeNode> sorted = new ArrayList<>();
        inorderTraversal(root, sorted);
        return sortedArrayToBST(sorted, 0, sorted.size() - 1);
    }

    private void inorderTraversal(TreeNode root, List<TreeNode> sorted) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, sorted);
        sorted.add(root);
        inorderTraversal(root.right, sorted);
    }

    private TreeNode sortedArrayToBST(List<TreeNode> nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;  // avoid overflow
        TreeNode node = nums.get(mid);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }
}
