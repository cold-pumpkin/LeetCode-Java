package dp.Maximum_Subarray;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    /*
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > 0)
                nums[i] = nums[i-1] + nums[i];
            res = Math.max(res, nums[i]);
        }
        return res;
    }*/
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            res = Math.max(sum, res);
            sum = Math.max(sum, 0);
        }
        return res;
    }
}