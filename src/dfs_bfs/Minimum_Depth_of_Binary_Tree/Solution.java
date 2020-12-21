package dfs_bfs.Minimum_Depth_of_Binary_Tree;

import com.sun.source.tree.Tree;
import stack_queue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // DFS
    /*
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    } */

    // BFS
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null)
                    return depth;
                if (curNode.left != null)
                    queue.offer(curNode.left);
                if (curNode.right != null)
                    queue.offer(curNode.right);
            }
        }
        return depth;
    }
}