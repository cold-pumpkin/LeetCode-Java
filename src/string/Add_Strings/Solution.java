package string.Add_Strings;

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            result.append(sum);
            i--;
            j--;
        }
        if (carry != 0)  result.append(carry);
        return result.reverse().toString();
    }
}