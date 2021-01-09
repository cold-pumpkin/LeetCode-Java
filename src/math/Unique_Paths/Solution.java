package math.Unique_Paths;

class Solution {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        double result = 1;
        for (int i = 0; i < Math.min(m-1, n-1); i++){
            result = result * (N - i) / (i + 1);
        }
        return (int)(result + 0.5);
    }
}