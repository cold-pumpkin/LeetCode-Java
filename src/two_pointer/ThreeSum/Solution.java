package two_pointer.ThreeSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length < 3)
            return result;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i-1] == nums[i])
                continue;
            int l = i+1, r = nums.length-1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l+1]) l++;
                    while(l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) l++;
                else r--;
            }
        }
        return result;
    }
}