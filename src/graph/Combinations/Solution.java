package graph.Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {


    /*// BFS
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || k == 0 || n < k) return result;

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>(k));    // initialCapacity

        while(!queue.isEmpty()) {
            List<Integer> combs = queue.poll();
            if (combs.size() == k) {
                result.add(combs);
                continue;
            }
            int combSize = combs.size();
            int start = combSize == 0 ? 1 : combs.get(combSize-1) + 1;  // 추가할 다음 요소
            for(int i = start; i <= n; i++) {
                List<Integer> newList = new ArrayList<>(combs);
                newList.add(i);
                queue.offer(newList);
            }
        }
        return result;
    }*/

    // DFS
    public static void dfs(int n, int k, List<Integer> combs, List<List<Integer>> result, int start) {
        if (combs.size() == k) {
            result.add(new ArrayList<>(combs));
            return;
        }
        for (int i = start; i <= n && k-combs.size() <= n - i + 1; i++) { // -> 성능 차이!
            combs.add(i);
            dfs(n, k, combs, result, i+1);
            combs.remove(combs.size()-1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, k, new LinkedList<Integer>(), result, 1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
