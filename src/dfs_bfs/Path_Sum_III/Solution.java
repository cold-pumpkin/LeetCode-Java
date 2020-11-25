package dfs_bfs.Path_Sum_III;

import stack_queue.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> cache = new HashMap<>();  // {누적 합: 도달한 경우}
        cache.put(0, 1);
        return dfs(root, 0, sum, cache);
    }

    public int dfs(TreeNode node, int currSum, int target, Map<Integer, Integer> cache) {
        if (node == null)
            return 0;
        currSum += node.val;
        int res = cache.getOrDefault(currSum - target, 0);  // 지나온 루트에 target을 만족한 경우가 있는지 확인
        cache.put(currSum, cache.getOrDefault(currSum, 0) + 1);  // 캐시 업데이트

        res += dfs(node.left, currSum, target, cache) + dfs(node.right, currSum, target, cache);

        cache.put(currSum, cache.get(currSum) - 1);  // 한쪽 다 돌고 다른 branch 가면 누적합 필요없어짐
        return res;
    }
}
