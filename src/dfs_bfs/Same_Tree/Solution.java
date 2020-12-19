package dfs_bfs.Same_Tree;

import stack_queue.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    // 1) Recursion
    /*
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    */

    // 2) Iteration
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;
        Deque<TreeNode> deqP = new ArrayDeque<>();
        Deque<TreeNode> deqQ = new ArrayDeque<>();
        deqP.add(p);
        deqQ.add(q);

        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p.left, q.left))
                return false;
            if(p.left != null) {
                deqP.addLast(p.left);
                deqQ.addLast(q.left);
            }

            if (!check(p.right, q.right))
                return false;
            if(p.right != null) {
                deqP.addLast(p.right);
                deqQ.addLast(q.right);
            }
        }
        return true;
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return true;
    }
}
