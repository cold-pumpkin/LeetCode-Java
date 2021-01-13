package two_pointer.Minimum_Size_Subarray_Sum;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int result = nums.length + 1;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                result = Math.min(result, i - left + 1);
                sum -= nums[left++];
            }
        }
        return result != nums.length + 1 ? result : 0;
    }
}
