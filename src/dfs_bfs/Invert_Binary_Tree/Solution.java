package dfs_bfs.Invert_Binary_Tree;

import com.sun.source.tree.Tree;
import stack_queue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Recursive
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    /* Iterative
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return root;
    }*/
}