package cn.sabercon.algorithm.q400.q390;

/**
 * Ransom Note
 *
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * @author ywk
 * @date 2020-04-29
 */
public class Q383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomCount = new int[26];
        for (char c : ransomNote.toCharArray()) {
            ransomCount[c - 'a']++;
        }
        int count = ransomNote.length();
        for (char c : magazine.toCharArray()) {
            if (ransomCount[c - 'a'] > 0) {
                ransomCount[c - 'a']--;
                count--;
            }
        }
        return count == 0;
    }
}
