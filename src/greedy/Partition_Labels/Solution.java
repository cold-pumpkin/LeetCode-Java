package greedy.Partition_Labels;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] rightmostIdx = new int[26];  // 0: a ... 25: z
        for (int i = 0; i < S.length(); i++) {
            rightmostIdx[S.charAt(i) - 'a'] = i;
        }
        int l = 0, r = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            r = Math.max(r, rightmostIdx[S.charAt(i) - 'a']);
            if (i == r) {
                result.add(r - l + 1);
                l = i + 1;
            }
        }
        return result;
    }
}


class Main {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(new Solution().partitionLabels(S));
    }
}

