package hashtable.Word_Pattern;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mapChar = new HashMap<>();
        Map<String, Character> mapWord = new HashMap<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length)
            return false;

        for (int i = 0; i < words.length; i++) {
            char p = pattern.charAt(i);
            String word = words[i];
            if (!mapChar.containsKey(p)) {
                if (mapWord.containsKey(word)) {
                    return false;
                } else {
                    mapChar.put(p, word);
                    mapWord.put(word, p);
                }
            } else {
                if (!mapChar.get(p).equals(word))
                    return false;
            }
        }
        return true;
    }
}