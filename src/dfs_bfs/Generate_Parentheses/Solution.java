package dfs_bfs.Generate_Parentheses;

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<String> result = new LinkedList<>();

    public void dfs(String parenthesis, int n, int left, int right) {
        if (parenthesis.length() == 2 * n) {
            result.add(parenthesis);
            return;
        }
        if (left < n)
            dfs(parenthesis + "(", n,left + 1, right);
        if (right < left)
            dfs(parenthesis + ")", n,left, right + 1);
    }

    public List<String> generateParenthesis(int n) {
        dfs("(", n, 1, 0);
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
        System.out.println(new Solution().generateParenthesis(1));
    }
}