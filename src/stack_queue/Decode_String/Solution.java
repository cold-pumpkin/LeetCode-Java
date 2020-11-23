package stack_queue.Decode_String;

import java.util.Stack;

class Solution {
    // Stack
    /*
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder curStr = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(k);
                strStack.push(curStr);
                curStr = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder temp = curStr;
                curStr = strStack.pop();
                for (k = numStack.pop(); k > 0; --k) curStr.append(temp);
            } else { // char
                curStr.append(c);
            }
        }
        return curStr.toString();
    }*/

    // Recursive
    private int i = 0;

    public String decodeString(String s) {
        StringBuilder curStr = new StringBuilder();
        int k = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') { // recursive call
                i++;
                String str = decodeString(s);
                for (int j = 0; j < k; j++) curStr.append(str);
                k = 0;
            } else if (c == ']') {  // base condition
                return curStr.toString();
            } else if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else {
                curStr.append(c);
            }
        }
        return curStr.toString();
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));  // "aaabcbc"
    }
}