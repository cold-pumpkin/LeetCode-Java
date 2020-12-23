package array.Pascal_Triangle_II;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0)
            return result;
        for (int i = 0; i <= rowIndex; i++) {
            result.add(0, 1);  // shifting the older value right
            for (int j = 1; j < i; j++) {
                result.set(j, result.get(j) + result.get(j+1));
            }
        }
        return result;
    }
}