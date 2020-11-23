package heap.Top_K_Frequent_Elements;

import java.util.*;
/*
class Pair<L,R> {
    final L left;
    final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    static <L,R> Pair<L,R> of(L left, R right){
        return new Pair<L,R>(left, right);
    }
}*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length)
            return nums;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (int key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) heap.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; --i)
            result[i] = heap.poll();
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(new Solution().topKFrequent(nums, 2)));
    }
}