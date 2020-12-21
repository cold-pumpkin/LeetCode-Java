package dfs_bfs.Convert_Sorted_Array_to_Binary_Search_Tree;

import stack_queue.TreeNode;

import java.util.Arrays;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null)
            return null;
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));
        return root;
    }
}