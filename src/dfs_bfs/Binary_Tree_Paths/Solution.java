package dfs_bfs.Binary_Tree_Paths;

import stack_queue.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, new StringBuilder(), result);
        return result;
    }

    public void helper(TreeNode node, StringBuilder path, List<String> result) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            result.add(path.append(node.val).toString());
            return;
        }
        path.append(node.val).append("->");
        int len = path.length();
        helper(node.left, path, result);
        path.setLength(len);
        helper(node.right, path, result);
        path.setLength(len);
    }
}