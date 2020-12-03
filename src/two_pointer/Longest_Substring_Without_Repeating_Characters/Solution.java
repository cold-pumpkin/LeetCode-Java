package two_pointer.Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding Window
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();  // 문자 : 해당 문자의 인덱스
        for (int r = 0, l = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r)))
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            ans = Math.max(ans, r - l + 1);
            map.put(s.charAt(r), r);
        }
        return ans;
    }
}