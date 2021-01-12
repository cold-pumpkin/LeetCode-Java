package dfs_bfs.Binary_Tree_Right_Side_View;

import stack_queue.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        helper(root, 0, result);
        return result;

    }

    public void helper(TreeNode node, int depth, List<Integer> result) {
        if (node == null)
            return;
        if (depth == result.size())
            result.add(node.val);
        helper(node.right, depth + 1, result);
        helper(node.left, depth + 1, result);
    }
}
