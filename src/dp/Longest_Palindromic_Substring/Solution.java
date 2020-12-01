package dp.Longest_Palindromic_Substring;

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(extendAroundCenter(s, i, i), extendAroundCenter(s, i, i+1));
            if (len > end - start) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int extendAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}