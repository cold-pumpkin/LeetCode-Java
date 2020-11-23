package dp.House_Robber_III;

import stack_queue.TreeNode;

class Solution {
    // 리프노트에서부터 올라오기
    /*
    public int robInclude(TreeNode node) {
        if (node == null)
            return 0;
        return node.val + robExclude(node.left) + robExclude(node.right);
    }

    public int robExclude(TreeNode node) {
        if (node == null)
            return 0;
        return rob(node.left) + rob(node.right);
    }

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(robInclude(root), robExclude(root));
    }
    */
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    public int[] dfs(TreeNode node) {
        int[] res = new int[2];  // {훔침, 안훔침}
        if (node == null)
            return res;
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        res[0] = node.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
