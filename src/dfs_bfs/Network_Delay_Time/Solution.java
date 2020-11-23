package dfs_bfs.Network_Delay_Time;

import java.util.*;

// 다익스트라 알고리즘
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // 그래프 초기화 { 출발점 : [ [도착점, 거리], ... ],  ... ] }
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if(!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        Map<Integer, Integer> distance = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        heap.add(new int[] {0, K});  // [거리, 노드]
        while (!heap.isEmpty()) {
            int[] polled = heap.poll();
            int curDist = polled[0], curNode = polled[1];
            if (!distance.containsKey(curNode)) {
                distance.put(curNode, curDist);
//                System.out.println("curNode: " + curNode);
                if (graph.containsKey(curNode)) {
                    for (int[] edge : graph.get(curNode)) {
                        int nxtNode = edge[0], nxtDist = edge[1];
                        int alt = curDist + nxtDist;
                        heap.add(new int[] {alt, nxtNode});  // [거리, 노드]
                    }
                }
            }
        }
        if (distance.size() == N)
            return Collections.max(distance.values());
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] times = { {2, 1, 1}, {2, 3, 1}, {3, 4, 1} };
        int N = 4, K = 2;
        System.out.println(sol.networkDelayTime(times, N, K));
    }
}
