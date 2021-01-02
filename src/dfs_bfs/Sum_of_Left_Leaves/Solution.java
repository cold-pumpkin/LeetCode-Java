package dfs_bfs.Sum_of_Left_Leaves;

import stack_queue.TreeNode;

import java.util.Stack;

public class Solution {
    // Recursive
    /*
    public int sumOfLeftLeaves(TreeNode root) {
        // base condition
        if (root == null)
            return 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }*/
    // Iterative
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int result = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    result += node.left.val;
                stack.push(node.left);
            }
            if (node.right != null)
                stack.push(node.right);
        }
        return result;
    }
}
