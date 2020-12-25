package hashtable.Isomorphic_String;

import java.util.Arrays;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mem1 = new int[256];
        int[] mem2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (mem1[s.charAt(i)] != mem2[t.charAt(i)])
                return false;
            mem1[s.charAt(i)] = i+1;
            mem2[t.charAt(i)] = i+1;
        }
        return true;
    }
}