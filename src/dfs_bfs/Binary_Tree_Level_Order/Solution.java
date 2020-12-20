package dfs_bfs.Binary_Tree_Level_Order;

import com.sun.source.tree.Tree;
import stack_queue.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // BFS
    /*
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = deque.pollFirst();
                level.add(curNode.val);
                if (curNode.left != null)
                    deque.offer(curNode.left);
                if (curNode.right != null)
                    deque.offer(curNode.right);
            }
            result.add(0, level);
        }
        return result;
    }*/

    // DFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        dfs(0, root, result);
        return result;
    }

    public void dfs(int level, TreeNode node, List<List<Integer>> result) {
        if (node == null) return;
        if (result.size() <= level)
            result.add(0, new LinkedList<>());
        dfs(level + 1, node.left, result);
        dfs(level + 1, node.right, result);
        result.get(result.size()-level-1).add(node.val);
    }


}
