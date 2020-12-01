package binary_search.Search_a_2D_Matrix_II;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return false;

        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                col++;
            else if (matrix[row][col] > target)
                row--;
        }
        return false;
    }
}