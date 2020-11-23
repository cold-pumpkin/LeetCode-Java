package two_pointer.Sort_Colors;

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        //red : 0, white : 1, blue : 2
        int red = 0, white = 0, blue = nums.length - 1;
        while (white <= blue) {
            if (nums[white] == 0) {
                // swap : white <-> red
                int temp = nums[white];
                nums[white] = nums[red];
                nums[red] = temp;
                white++;
                red++;
            } else if (nums[white] == 2) {
                // swap : white <-> blue
                int temp = nums[white];
                nums[white] = nums[blue];
                nums[blue] = temp;
                blue--;
            } else {
                white++;
            }
        }
    }
}
