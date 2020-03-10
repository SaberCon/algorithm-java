package cn.sabercon.algorithm.q100.q30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Substring with Concatenation of All Words
 * <p>
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * Example 1:
 * Input:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * <p>
 * Example 2:
 * Input:
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * Output: []
 *
 * @author ywk
 * @date 2020-03-10
 */
public class Q30 {

    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> results = new ArrayList<>();
        if (words.length == 0 || words[0].length() == 0) {
            return results;
        }
        HashMap<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        int wordLength = words[0].length();
        int totalLength = words.length * wordLength;
        for (int i = 0; i <= s.length() - totalLength; i++) {
            HashMap<String, Integer> tempMap = (HashMap<String, Integer>) map.clone();
            int j = i;
            while (j - i < totalLength) {
                String sub = s.substring(j, j + wordLength);
                if (tempMap.containsKey(sub) && tempMap.get(sub) > 0) {
                    tempMap.put(sub, tempMap.get(sub) - 1);
                    j += wordLength;
                } else {
                    break;
                }
            }
            if (j - i >= totalLength) {
                results.add(i);
            }
        }
        return results;
    }
}
