package cn.sabercon.algorithm.q100.q80;

import java.util.HashMap;

/**
 * Minimum Window Substring
 * <p>
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * @author ywk
 * @date 2020-03-17
 */
public class Q76 {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>(t.length());
        HashMap<Character, Integer> sMap = new HashMap<>(t.length());
        int count = 0;
        for (char c : t.toCharArray()) {
            sMap.put(c, 0);
            if (!tMap.containsKey(c)) {
                tMap.put(c, 1);
            } else {
                tMap.put(c, tMap.get(c) + 1);
            }
            count++;
        }
        char[] chars = s.toCharArray();
        int minBegin = 0;
        int minEnd = -1;
        int start = -1;
        for (int i = 0; i < chars.length; i++) {
            if (sMap.containsKey(chars[i])) {
                if (start == -1) {
                    start = i;
                }
                Integer num = sMap.get(chars[i]);
                sMap.put(chars[i], num + 1);
                if (num < tMap.get(chars[i])) {
                    count--;
                    if (count == 0) {
                        minBegin = start;
                        minEnd = i;
                    }
                } else {
                    for (int j = start; j < i; j++) {
                        if (sMap.containsKey(chars[j])) {
                            if (sMap.get(chars[j]) <= tMap.get(chars[j])) {
                                break;
                            } else {
                                sMap.put(chars[j], sMap.get(chars[j]) - 1);
                            }
                        }
                        start++;
                    }
                    if (count == 0 && minEnd - minBegin > i - start) {
                        minBegin = start;
                        minEnd = i;
                    }
                }
            }
        }
        return s.substring(minBegin, minEnd + 1);
    }

    public static void main(String[] args) {
        Q76 q76 = new Q76();
        System.out.println(q76.minWindow("acbbaca", "aba"));
    }
}
