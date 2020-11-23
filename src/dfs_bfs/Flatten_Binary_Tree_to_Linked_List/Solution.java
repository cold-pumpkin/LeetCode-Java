package dfs_bfs.Flatten_Binary_Tree_to_Linked_List;

import stack_queue.TreeNode;

import java.util.Stack;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode prev = new TreeNode(-1);
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            prev.right = node;
            prev.left = null;
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            prev = node;
        }
    }
}
