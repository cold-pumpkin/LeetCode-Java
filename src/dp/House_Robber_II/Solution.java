package dp.House_Robber_II;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(simpleRob(nums, 0, nums.length-1), simpleRob(nums, 1, nums.length));
    }

    public int simpleRob(int[] nums, int left, int right) {
        int prevN = 0, prevY = 0;  // 안 훔침, 훔침
        while (left < right) {
            int temp = prevN;
            prevN = Math.max(prevN, prevY);  // 안 훔침 (직전에 안 훔침 vs 직전에 훔침)
            prevY = temp + nums[left++];  // 훔침 (직전에 안 훔침 + 현재 돈)
        }
        return Math.max(prevN, prevY);
    }
}