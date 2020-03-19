package cn.sabercon.algorithm.q100.q100;

import java.util.HashMap;
import java.util.Map;

/**
 * Decode Ways
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * @author ywk
 * @date 2020-03-19
 */
public class Q91 {

    public int numDecodings(String s) {
        return dynamicProgramming(s, new HashMap<>());
    }

    private int dynamicProgramming(String s, Map<String, Integer> map) {
        if (s.length() == 0) {
            return 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int num = 0;
        if (s.charAt(0) > '2') {
            num += dynamicProgramming(s.substring(1), map);
        } else if (s.charAt(0) == '2') {
            if (s.charAt(1) > '6') {
                num += dynamicProgramming(s.substring(1), map);
            } else {
                num += dynamicProgramming(s.substring(1), map);
                num += dynamicProgramming(s.substring(2), map);
            }
        } else if (s.charAt(0) == '1') {
            num += dynamicProgramming(s.substring(1), map);
            num += dynamicProgramming(s.substring(2), map);
        }
        map.put(s, num);
        return num;
    }
}
