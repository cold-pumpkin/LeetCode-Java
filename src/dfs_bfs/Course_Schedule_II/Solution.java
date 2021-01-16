package dfs_bfs.Course_Schedule_II;


import java.util.*;

/*
class Solution {
    // Approach 1: Using Depth First Search
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;
    boolean isPossible = true;
    Map<Integer, List<Integer>> courseGraph = new HashMap<>();
    Map<Integer, Integer> color = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // WHITE로 초기화
        for (int i = 0; i < numCourses; i++)
            color.put(i, WHITE);
        // 그래프 구성 {코스 : [다음 수강 가능 코스들]}
        for (int[] prerequisite : prerequisites) {
            int post = prerequisite[0];
            int pre = prerequisite[1];
            List<Integer> adj = courseGraph.getOrDefault(pre, new ArrayList<Integer>());
            adj.add(post);
            courseGraph.put(pre, adj);
        }
        // 탐색
        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHITE)
                dfs(i);
        }
        // 결과 출력
        if (!isPossible)
            return new int[0];
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = result.get(numCourses - i - 1);
        }
        return order;
    }

    private void dfs(int node) {
        if (!isPossible)
            return;
        color.put(node, GRAY);
        if (courseGraph.containsKey(node)) {
            for (int next : courseGraph.get(node)) {
                if (color.get(next) == WHITE) {
                    dfs(next);
                } else if (color.get(next) == GRAY) {
                    isPossible = false;
                }
            }
        }
        // recursion 종료
        color.put(node, BLACK);
        result.add(node);
    }
}

/*
class Solution {
    // Approach 2: Using Node Indegree
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseGraph = new HashMap<>();
        int[] degree = new int[numCourses];
        int[] result = new int[numCourses];
        // 그래프, 차수 배열 구성
        for (int[] prerequisite : prerequisites) {
            int post = prerequisite[0];
            int pre = prerequisite[1];
            List<Integer> adj = courseGraph.getOrDefault(pre, new ArrayList<Integer>());
            adj.add(post);
            courseGraph.put(pre, adj);
            degree[post]++;
        }
        // 차수 0인 과목들 큐
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0)
                queue.offer(i);
        }
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[i++] = node;
            if (courseGraph.containsKey(node)) {
                for (int next : courseGraph.get(node)) {
                    degree[next]--;
                    if (degree[next] == 0)
                        queue.offer(next);
                }
            }
        }
        if (i < numCourses)
            return new int[0];
        return result;
    }
}
*/
class Solution {
    int[] color;
    List<List<Integer>> courseGraph;
    List<Integer> result;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        courseGraph = new ArrayList<>();
        color = new int[numCourses];  // 0 : White / 1 : Gray / 1 : Black
        for (int i = 0; i < numCourses; i++) {
            courseGraph.add(new ArrayList<Integer>());
        }

        for (int[] prerequisite : prerequisites)
            courseGraph.get(prerequisite[1]).add(prerequisite[0]);

        result = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (color[i] == 0 && !dfs(i)) {
                return new int[0];
            }
        }
        Collections.reverse(result);
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private boolean dfs(int node) { // false : cycle
        color[node] = 1;
        for (int i = 0; i < courseGraph.get(node).size(); i++) {
            int next = courseGraph.get(node).get(i);
            if (color[next] == 0 && !dfs(next)) {
                return false;
            } else if (color[next] == 1) {
                return false;
            }
        }
        color[node] = 2;
        result.add(node);
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][] { {1, 0} };
        System.out.println(Arrays.toString(new Solution().findOrder(numCourses, prerequisites)));

        numCourses = 4;
        prerequisites = new int[][] { {1, 0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(new Solution().findOrder(numCourses, prerequisites)));
    }
}
