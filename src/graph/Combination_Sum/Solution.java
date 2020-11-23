package graph.Combination_Sum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //List<Integer> combs = new ArrayList<>();
        dfs(new ArrayList<>(), candidates, 0, target, 0);
        return result;
    }

    public void dfs(List<Integer> combs, int[] candidates, int start, int target, int accSum) {
        if (accSum == target) {
            result.add(new ArrayList<>(combs));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if (accSum + candidates[i] <= target) {
                combs.add(candidates[i]);
                dfs(combs, candidates, i, target, accSum + candidates[i]);
                combs.remove(combs.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[] {2, 3, 6, 7};
        int target = 7;
        System.out.println(new Solution().combinationSum(candidates, target));
    }


}

