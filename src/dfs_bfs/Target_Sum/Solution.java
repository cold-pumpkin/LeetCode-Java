package dfs_bfs.Target_Sum;

import java.util.Arrays;

class Solution {

    public int dfs(int[] nums, int S, int idx, int currSum, int[][] memo) {
        // base condition
        if (idx == nums.length) {
            if (currSum == S)
                return 1;
            return 0;
        }
        // memoization
        if (memo[idx][currSum + 1000] != Integer.MIN_VALUE)
            return memo[idx][currSum + 1000];

        // +/- 재귀호출, 경우의 수 리턴
        int plus = dfs(nums, S, idx + 1, currSum + nums[idx], memo);
        int minus = dfs(nums, S, idx + 1, currSum - nums[idx], memo);
        memo[idx][currSum + 1000] = plus + minus;

        return memo[idx][currSum + 1000];
    }
    public int findTargetSumWays(int[] nums, int S) {
        // [idx][누적합] = 경우의 수
        int[][] memo = new int[nums.length][2001]; // 누적합은 1000을 넘지 않으므로, 최대 2000 / 최소 -2000
        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return dfs(nums, S, 0, 0, memo);
    }
}