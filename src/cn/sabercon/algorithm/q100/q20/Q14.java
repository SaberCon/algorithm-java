package cn.sabercon.algorithm.q100.q20;

/**
 * Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Note:
 * All given inputs are in lowercase letters a-z.
 *
 * @author ywk
 * @date 2020-03-08
 */
public class Q14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int prefix = 0;
        while (true) {
            if (notMatch(strs, prefix)) break;
            prefix++;
        }
        return strs[0].substring(0, prefix);
    }

    private boolean notMatch(String[] strs, int index) {
        if (strs[0].length() <= index) {
            return true;
        }
        char c = strs[0].charAt(index);
        for (String str : strs) {
            if (str.length() <= index || str.charAt(index) != c) {
                return true;
            }
        }
        return false;
    }
}
