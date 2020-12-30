package binary_search.Valid_Perfect_Square;

class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int q = num / mid, r = num % mid;
            if (r == 0 && q == mid)
                return true;
            else if (q < mid)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}
