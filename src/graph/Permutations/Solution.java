package graph.Permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void dfs(int level, int[] nums, List<Integer> perms, List<List<Integer>> ansList) {
        if (level == nums.length) {
            ansList.add(new ArrayList<>(perms));
        }
        for (int num : nums) {
            if (!perms.contains(num)) {
                perms.add(num);
                dfs(level+1, nums, perms, ansList);
                perms.remove(perms.size()-1);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)  return Collections.emptyList();

        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> perms = new ArrayList<>();

        dfs(0, nums, perms, ansList);
        return ansList;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
//        int[] nums = new int[] {1};
        System.out.println(permute(nums));
    }
}
