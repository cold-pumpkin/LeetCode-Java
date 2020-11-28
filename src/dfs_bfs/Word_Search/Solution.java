package dfs_bfs.Word_Search;

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && search(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board, int r, int c, String word, int idx) {
        // base condition
        if (idx == word.length())
            return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length)
            return false;
        if (board[r][c] != word.charAt(idx))
            return false;
        // search
        board[r][c] = '-';  // 재방문 방지
        boolean res = search(board, r+1, c, word, idx+1)
                || search(board, r, c+1, word, idx+1)
                || search(board, r-1, c, word, idx+1)
                || search(board, r, c-1, word, idx+1);
        board[r][c] = word.charAt(idx); // 원복
        return res;
    }
}