package hashtable.GroupAnagrams;

import java.sql.PreparedStatement;
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> result = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!result.containsKey(key))
                result.put(key, new ArrayList());
            result.get(key).add(str);
        }
        return new ArrayList(result.values());
    }
    /*
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> result = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count,0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!result.containsKey(key)) result.put(key, new ArrayList());
            result.get(key).add(str);
        }
        return new ArrayList(result.values());
    }*/
}