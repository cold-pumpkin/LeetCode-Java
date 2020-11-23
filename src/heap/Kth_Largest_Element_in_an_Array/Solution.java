package heap.Kth_Largest_Element_in_an_Array;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        Arrays.sort(nums);
        return nums[nums.length - k];
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums)
            pq.offer(num);

        for (int i = 0; i < k-1; i++)
            pq.poll();


        return pq.peek();
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
//        System.out.println(new Solution().findKthLargest(nums, k));

        //int[] nums = {3,2,3,1,2,4,5,5,6};
        //int k = 4;
        System.out.println(new Solution().findKthLargest(nums, k));
    }
}