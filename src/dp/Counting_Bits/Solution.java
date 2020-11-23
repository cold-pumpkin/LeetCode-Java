package dp.Counting_Bits;

import java.util.Arrays;

class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            result[i] = result[i>>1] + (i & 1);
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countBits(2)));
        System.out.println(Arrays.toString(new Solution().countBits(5)));
    }
}