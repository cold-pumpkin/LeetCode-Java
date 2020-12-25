package math.Count_Primes;

public class Solution {
    public int countPrimes(int n) {
        if (n < 2)
            return 0;
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i ++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < notPrime.length; i++) {
            if (!notPrime[i]) count++;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(10));
        System.out.println(new Solution().countPrimes(0));
        System.out.println(new Solution().countPrimes(1));
        System.out.println(new Solution().countPrimes(2));
        System.out.println(new Solution().countPrimes(20));
    }
}
