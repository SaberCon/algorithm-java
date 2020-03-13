package cn.sabercon.algorithm.q100.q50;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * <p>
 * Example 1:
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * Example 2:
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * <p>
 * Example 3:
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * <p>
 * Example 4:
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * <p>
 * Example 5:
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 *
 * @author ywk
 * @date 2020-03-13
 */
public class Q44 {

    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        Queue<String> matchs = new LinkedList<>();
        s = 'a' + s + 'a';
        p = 'a' + p + 'a';
        int index = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                if (i != index) {
                    matchs.add(p.substring(index, i));
                }
                index = i + 1;
            }
        }
        matchs.add(p.substring(index));
        String firstMatch = matchs.poll();
        if (!startsWith(s, firstMatch)) {
            return false;
        }
        s = s.substring(firstMatch.length());
        if (matchs.isEmpty()) {
            return "".equals(s);
        }
        int length = matchs.size() - 1;
        for (int i = 0; i < length; i++) {
            String match = matchs.poll();
             index = indexOf(s, match);
            if (index == -1) {
                return false;
            }
            s = s.substring(index + match.length());
        }
        return endsWith(s, matchs.poll());
    }

    private boolean startsWith(String s, String match) {
        if (s.length() < match.length()) {
            return false;
        }
        for (int i = 0; i < match.length(); i++) {
            if (match.charAt(i) != '?' && match.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean endsWith(String s, String match) {
        if (s.length() < match.length()) {
            return false;
        }
        for (int i = 1; i <= match.length(); i++) {
            if (match.charAt(match.length() - i) != '?' && match.charAt(match.length() - i) != s.charAt(s.length() - i)) {
                return false;
            }
        }
        return true;
    }

    private int indexOf(String s, String match) {
        if (s.length() < match.length()) {
            return -1;
        }
        for (int i = 0; i <= s.length() - match.length(); i++) {
            if (startsWith(s.substring(i), match)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q44 q44 = new Q44();
        System.out.println(q44.isMatch("b", "*?*?*"));
    }
}
