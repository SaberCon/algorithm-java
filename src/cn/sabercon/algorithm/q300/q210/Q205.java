package cn.sabercon.algorithm.q300.q210;

import java.util.HashMap;
import java.util.Map;

/**
 * Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 *
 * @author ywk
 * @date 2020-03-31
 */
public class Q205 {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (sMap.containsKey(sc)) {
                if (tMap.containsKey(tc)) {
                    if (!sMap.get(sc).equals(tMap.get(tc))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (tMap.containsKey(tc)) {
                    return false;
                } else {
                    sMap.put(sc, i);
                    tMap.put(tc, i);
                }
            }
        }
        return true;
    }
}
