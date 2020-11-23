package dfs_bfs.Kth_Smallest_Element_in_a_BST;

import stack_queue.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    /* DFS
    List<Integer> result = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return result.get(k-1);
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        result.add(node.val);
        dfs(node.right);
    }
    */

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}


class Main {

}