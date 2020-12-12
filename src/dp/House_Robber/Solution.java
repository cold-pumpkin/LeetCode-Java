package dp.House_Robber;

class Solution {
    public int rob(int[] nums) {
        int prevN = 0, prevY = 0; // rob YN
        for (int num : nums) {
            int temp = prevN;
            prevN = Math.max(prevN, prevY);
            prevY = num + temp;
        }
        return Math.max(prevN, prevY);
    }
}