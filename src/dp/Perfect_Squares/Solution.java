package dp.Perfect_Squares;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // BFS
    public int numSquares(int n) {
        if (n <= 0)
            return 0;
        int[] dp = new int[n+1];  // dp[i] : 최소의 정사갹형으로 총 넓이 합 i 만들기
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i * i <= n; i++) {
            if (i*i == n)  // 정사각형 하나로 만들 수 있음
                return 1;
            dp[i*i] = 1;
            q.offer(i*i);
        }
        while (!q.isEmpty()) {  // 1 4 9
            int curr = q.peek();
            for (int i = 1; i*i <= n-curr; i++) {
                if (curr + i*i == n) {
                    return dp[curr] + 1;
                } else if ((curr + i*i < n) && (dp[curr + i*i] == 0)) {  // 처음인 경우
                    dp[curr + i*i] = dp[curr] + 1;
                    q.offer(curr + i*i);
                } else if (curr + i*i > n) {
                    break;
                }
            }
            q.poll();
        }
        return 0;
    }
}


class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));  // 3
        System.out.println(new Solution().numSquares(13));  // 2
    }
}