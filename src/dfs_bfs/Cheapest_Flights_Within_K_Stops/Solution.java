package dfs_bfs.Cheapest_Flights_Within_K_Stops;

import java.util.*;

class Solution {

    // 다익스트라
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 그래프 {출발점 : [[도착점, 거리], ... ] ...
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] flight : flights) {
            int u = flight[0], v = flight[1], w = flight[2];
            if (!graph.containsKey(u)) {
                graph.put(u, new LinkedList<>());
            }
            graph.get(u).add(new int[] {v, w});
        }
        // 힙 [ [거리, 노드, 경유 노드 개수], ... ]
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);  // 거리 오름차순
        heap.add(new int[] {0, src, K});
        while (!heap.isEmpty()) {
            int[] polledArr = heap.poll();
            int price = polledArr[0], node = polledArr[1], stopCnt = polledArr[2];

            if (node == dst) return price;
            if (stopCnt >= 0 && graph.containsKey(node)) {
                for (int[] flight : graph.get(node)) {
                    int nxt = flight[0];
                    int alt = price + flight[1];
                    heap.offer(new int[] {alt, nxt, stopCnt-1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /*int n = 3;
        int[][] edges =  new int[][] {{0,1,100}, {1,2,100}, {0,2,500}};
        int src = 0, dst = 2, k = 1;
        System.out.println(new Solution().findCheapestPrice(n, edges, src, dst, k));

        n = 3;
        edges = new int[][] {{0,1,100}, {1,2,100}, {0,2,500}};
        src = 0;
        dst = 2;
        k = 0;
        System.out.println(new Solution().findCheapestPrice(n, edges, src, dst, k));

        n = 5;
        edges = new int[][] {{4,1,1}, {1,2,3}, {0,3,2}, {0,4,10}, {3,1,1}, {1,4,3}};
        src = 2;
        dst = 1;
        k = 1;
        System.out.println(new Solution().findCheapestPrice(n, edges, src, dst, k));*/

        int n = 4;
        int[][] edges = new int[][] {{0,1,1}, {0,2,5}, {1,2,1}, {2,3,1}};
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(new Solution().findCheapestPrice(n, edges, src, dst, k)); // 6
    }
}