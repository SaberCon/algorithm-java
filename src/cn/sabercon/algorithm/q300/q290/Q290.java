package cn.sabercon.algorithm.q300.q290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Word Pattern
 * <p>
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 * <p>
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 * <p>
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 * <p>
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 *
 * @author ywk
 * @date 2020-04-16
 */
public class Q290 {

    public boolean wordPattern(String pattern, String str) {
        char[] patterns = pattern.toCharArray();
        String[] strings = str.split(" ");
        if (patterns.length != strings.length) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            if (set.contains(patterns[i])) {
                if (!map.containsKey(strings[i]) || !map.get(strings[i]).equals(patterns[i])) {
                    return false;
                }
            } else {
                if (map.containsKey(strings[i])) {
                    return false;
                }
                set.add(patterns[i]);
                map.put(strings[i], patterns[i]);
            }
        }
        return true;
    }
}
