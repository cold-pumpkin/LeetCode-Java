package two_pointer.Move_Zeroes;

class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, last = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[last];
                nums[last++] = temp;
            }
        }
    }
}