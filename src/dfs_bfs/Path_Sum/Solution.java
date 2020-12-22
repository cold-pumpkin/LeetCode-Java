package dfs_bfs.Path_Sum;

import stack_queue.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // base condition
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;

        sum -= root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}