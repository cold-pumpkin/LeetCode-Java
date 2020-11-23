package dfs_bfs.Course_Schedule;

import java.util.*;

class Solution {
    // {선행코스 : [다음코스, ...] }
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public void dfs(int src, int[] degrees, boolean[] visited) {
        visited[src] = true;
        if (!graph.containsKey(src))
            return;

        for (int next : graph.get(src)) {
            degrees[next] -= 1;
            if (degrees[next] == 0 && !visited[next])
                dfs(next, degrees, visited);
        }

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
        }

        for(int[] edge : prerequisites) {
            int to = edge[0], from = edge[1];
            graph.get(from).add(to);
            degrees[to]++;
        }

        for (int src : graph.keySet()) {
            if (degrees[src] == 0 && !visited[src])
                dfs(src, degrees, visited);  // 탐색 시작
        }

        for (boolean flag : visited) {
            if (!flag) return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {

        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        System.out.println(new Solution().canFinish(numCourses, prerequisites));  // T

        numCourses = 2;
        prerequisites = new int[][]{{1, 0}, {0,1}};
        System.out.println(new Solution().canFinish(numCourses, prerequisites)); // F

        numCourses = 4;
        prerequisites = new int[][]{{2,0}, {1,0}, {3,1}, {3,2}, {1,3}};
        System.out.println(new Solution().canFinish(numCourses, prerequisites)); // F

        numCourses = 1;
        prerequisites = new int[][]{};
        System.out.println(new Solution().canFinish(numCourses, prerequisites)); // T
    }
}
