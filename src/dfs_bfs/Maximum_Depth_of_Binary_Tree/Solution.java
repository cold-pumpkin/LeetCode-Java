package dfs_bfs.Maximum_Depth_of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

// * Definition for a binary tree node.
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
    // DFS
    /*public static int maxDepth(dfs_bfs.TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }*/

    // BFS
    public static int maxDepth(TreeNode root) {
        int ans = 0;
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 같은 레벨의 노드의 자식들은 모두 큐에 넣고 나서 ans++
        while (!queue.isEmpty()) {
            // 같은 레벨 있는 노드 다 빼고 자식들 넣기
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        // [0,2,4,1,null,3,-1,5,1,null,6,null,8]
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(-1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);
        root.right.left.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);

        System.out.println(maxDepth(root));
    }
}