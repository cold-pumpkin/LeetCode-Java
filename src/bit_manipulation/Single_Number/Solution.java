package bit_manipulation.Single_Number;

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums)
            res ^= num;  // XOR
        return res;
    }
}