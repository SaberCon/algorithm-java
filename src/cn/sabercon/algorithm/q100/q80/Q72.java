package cn.sabercon.algorithm.q100.q80;

import java.util.HashMap;
import java.util.Map;

/**
 * Edit Distance
 * <p>
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * <p>
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * <p>
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * @author ywk
 * @date 2020-03-17
 */
public class Q72 {

    public int minDistance(String word1, String word2) {
        return covertTo(word1, word2, new HashMap<>());
    }

    private int covertTo(String src, String dest, Map<String, Integer> map) {
        String key = src + " " + dest;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        for (int i = 0; i < src.length(); i++) {
            if (dest.length() <= i) {
                map.put(key, src.length() - dest.length());
                return src.length() - dest.length();
            }
            if (src.charAt(i) != dest.charAt(i)) {
                int result = 1 + Math.min(Math.min(covertTo(src.substring(i + 1), dest.substring(i), map), covertTo(src.substring(i), dest.substring(i + 1), map)),
                        covertTo(src.substring(i + 1), dest.substring(i + 1), map));
                map.put(key, result);
                return result;
            }
        }
        map.put(key, dest.length() - src.length());
        return dest.length() - src.length();
    }
}
