package hashtable.First_Unique_Character_in_a_String;

import java.util.HashMap;
import java.util.stream.IntStream;

class Solution {
    /*
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }*/

    public int firstUniqChar(String s) {
        if (s.isEmpty())
            return -1;

        int result = -1;  // index of first non-repeating character so far
        for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            int idx = s.indexOf(c);
            if (idx != -1 && (result == -1 || idx < result) && idx == s.lastIndexOf(c))
                result = idx;
        }
        return result;
    }
}