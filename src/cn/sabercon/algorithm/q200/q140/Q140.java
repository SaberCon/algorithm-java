package cn.sabercon.algorithm.q200.q140;

import java.util.*;

/**
 * Word Break II
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 * <p>
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * <p>
 * @author ywk
 * @date 2020-03-24
 */
public class Q140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<String> result = new ArrayList<>();
        TreeMap<Integer, Set<String>> map = new TreeMap<>((e1, e2) -> e2 - e1);
        for (String word : wordDict) {
            int length = word.length();
            if (map.containsKey(length)) {
                map.get(length).add(word);
            } else {
                Set<String> set = new HashSet<>();
                set.add(word);
                map.put(length, set);
            }
        }
        BitSet bitSet = new BitSet(s.length());
        match(s, map, bitSet);
        return result;
    }

    private boolean match(String s, TreeMap<Integer, Set<String>> map, BitSet bitSet) {
        if (bitSet.get(s.length())) {
            return false;
        }
        for (Map.Entry<Integer, Set<String>> entry : map.entrySet()) {
            int length = entry.getKey();
            if (s.length() < length) {
                continue;
            }
            Set<String> set = entry.getValue();
            if (set.contains(s.substring(0, length))) {
                if (s.length() == length) {
                    return true;
                }
                if (match(s.substring(length), map, bitSet)) {
                    return true;
                }
            }
        }
        bitSet.set(s.length());
        return false;
    }
}
