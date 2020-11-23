package graph.Subsets;

import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> result = new LinkedList<>();

    public void dfs(int start, int[] nums, List<Integer> subset) {
        result.add(new LinkedList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(i+1, nums, subset);
            subset.remove(subset.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new LinkedList<>());
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        System.out.println(new Solution().subsets(nums));
    }


}