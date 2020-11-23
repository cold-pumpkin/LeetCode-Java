package dfs_bfs.Deepest_Leaves_Sum;

import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution {
     // BFS
    /*
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            result = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                result += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }
    */
    // DFS
    int maxDepth;
    int result;
     public int deepestLeavesSum(TreeNode root) {
         maxDepth = 0;
         result = 0;
         dfs(root, 0);
         return result;
     }

     public void dfs(TreeNode node, int depth) {
         if (depth > maxDepth) {
             result = node.val;
             maxDepth = depth;
         } else if (depth == maxDepth) {
             result += node.val;
         }
         if (node.left != null) dfs(node.left, depth + 1);
         if (node.right != null) dfs(node.right, depth + 1);
     }

}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        System.out.println(new Solution().deepestLeavesSum(root));
    }

}