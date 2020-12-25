package math.Happy_Number;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> memory = new HashSet<>();
        while (n != 1) {
            int tmp = 0;
            while (n > 0) {
                int rest = n % 10;
                tmp += rest * rest;
                n /= 10;
            }
            n = tmp;
            if (memory.contains(n))
                return false;
            else
                memory.add(n);
        }
        return true;
    }
}