package stack_queue.Valid_Parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) { // open
                stack.push(c);
            } else if (!stack.isEmpty() && c == map.get(stack.lastElement())){ // close
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}