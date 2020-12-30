package hashtable.Ransom_Note;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] memo = new int[26];
        for (int i = 0; i < magazine.length(); i++)
            memo[magazine.charAt(i)-'a']++;
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--memo[ransomNote.charAt(i)-'a'] < 0)
                return false;
        }
        return true;
    }
}