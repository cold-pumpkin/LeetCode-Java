package dp.Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), k, 1, n);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> path, int k, int start, int target) {
        if (path.size() == k && target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i < 10; i++) {
            path.add(i);
            helper(result, path, k, i + 1, target - i);
            path.remove(path.size() - 1);
        }
    }
}