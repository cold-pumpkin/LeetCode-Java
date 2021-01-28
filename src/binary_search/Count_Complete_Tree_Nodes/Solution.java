package binary_search.Count_Complete_Tree_Nodes;

import stack_queue.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    public int getDepth(TreeNode node) {
        return node == null ? 0 : 1 + getDepth(node.left);
    }
}
