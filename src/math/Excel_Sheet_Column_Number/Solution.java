package math.Excel_Sheet_Column_Number;

class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            result += Math.pow(26, s.length()-i-1) * (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("ZY"));
    }
}