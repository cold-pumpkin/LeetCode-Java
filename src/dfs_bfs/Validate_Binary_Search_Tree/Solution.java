package dfs_bfs.Validate_Binary_Search_Tree;

import com.sun.source.tree.Tree;
import stack_queue.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, long minVal, long maxVal) {
        if (node == null)
            return true;
        if (node.val >= maxVal || node.val <= minVal)
            return false;
        return helper(node.left, minVal, node.val) && helper(node.right, node.val, maxVal);
    }
}
