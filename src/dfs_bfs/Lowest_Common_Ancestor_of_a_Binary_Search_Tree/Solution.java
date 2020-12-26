package dfs_bfs.Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import stack_queue.TreeNode;

public class Solution {

    // Recursion
    /*
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (p.val > rootVal && q.val > rootVal)
            return lowestCommonAncestor(root.right, p, q);
        else if (p.val < rootVal && q.val < rootVal)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }
    */
    // Iteration
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (node != null) {
            int parentVal = node.val;
            if (p.val > parentVal && q.val > parentVal)
                node = node.right;
            else if (p.val < parentVal && q.val < parentVal)
                node = node.left;
            else
                return node;
        }
        return root;
    }
}
