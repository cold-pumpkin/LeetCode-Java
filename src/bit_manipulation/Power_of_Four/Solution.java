package bit_manipulation.Power_of_Four;

public class Solution {
    public boolean isPowerOfFour(int n) {
        return (n & (n-1)) == 0 && (n-1) % 3 == 0;
    }
}
