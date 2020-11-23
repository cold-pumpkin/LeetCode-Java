package stack_queue.Daily_Temperatures;

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                // warmer
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }
}


class Main {
    public static void main(String[] args) {
        int[] T = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(new Solution().dailyTemperatures(T));
    }
}