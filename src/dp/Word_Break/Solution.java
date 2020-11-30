package records.Word_Break;

import java.util.Arrays;
import java.util.List;

class Solution {
    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] records = new boolean[s.length()+1];
        records[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(records[j] && wordDict.contains(s.substring(j, i))) {
                    records[i] = true;
                    break;
                }
            }
        }
        return records[s.length()];
    }*/

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty())
            return false;

        int[] records = new int[s.length()];
        Arrays.fill(records, -1);
        return helper(s, wordDict, records, 0);
    }

    public boolean helper(String s, List<String> wordDict, int[] records, int idx) {
        // base condition
        if (idx == s.length())
            return true;
        if (records[idx] == 0)
            return false;
        if (records[idx] == 1)
            return true;

        for (String word : wordDict) {
            if (s.startsWith(word, idx)) {
                if (helper(s, wordDict, records, idx + word.length())) {
                    records[idx] = 1;
                    return true;
                }
            }
        }
        records[idx] = 0;
        return false;
    }
}