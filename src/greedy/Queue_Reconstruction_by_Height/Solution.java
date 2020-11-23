package greedy.Queue_Reconstruction_by_Height;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // (h, k) : h 내림차순, k 오름차순
        /*
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        //System.out.println(Arrays.deepToString(people));
        List<int[]> result = new LinkedList<>();
        for(int[] p : people) {
            result.add(p[1], p);
        }
        return result.toArray(new int[people.length][2]);
        */
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        for (int[] p : people) {
            queue.offer(p);
        }
        List<int[]> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            result.add(p[1], p);
        }
        return result.toArray(new int[people.length][2]);
    }
}


class Main {
    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        System.out.println(new Solution().reconstructQueue(people));
    }
}