package array.Longest_Common_Prefix;

import java.util.Arrays;

class Solution {
    /*
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        String s1 = strs[0], s2 = strs[strs.length-1];
        int n = Math.min(s1.length(), s2.length());
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i))
                sb.append(s1.charAt(i));
            else
                break;
        }
        return String.valueOf(sb);
    }*/

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String comp = strs[i];
            while (comp.indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length()-1);
        }
        return prefix;
    }
}