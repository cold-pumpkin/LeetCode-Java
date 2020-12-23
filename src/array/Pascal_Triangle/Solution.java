package array.Pascal_Triangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else {
                    int x = result.get(i-1).get(j-1);
                    int y = result.get(i-1).get(j);
                    row.add(x+y);
                }
            }
            result.add(row);
        }
        return result;
    }
}