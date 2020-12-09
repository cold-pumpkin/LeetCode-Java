package array.Find_All_Numbers_Disappeared_in_an_Array;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            nums[idx] = -Math.abs(nums[idx]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }
}