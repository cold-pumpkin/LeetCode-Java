package stack_queue.Binary_Tree_Inorder_Traversal;

import stack_queue.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    /*
    // DFS를 이용한 in-order
    List<Integer> result = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }
    public void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.left);
            result.add(node.val);
            dfs(node.right);
        }
    }
 */
    // 스택을 이용한 in-order
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null)  {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(new Solution().inorderTraversal(root));
    }
}