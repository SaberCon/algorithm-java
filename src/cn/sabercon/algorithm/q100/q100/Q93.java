package cn.sabercon.algorithm.q100.q100;

import java.util.ArrayList;
import java.util.List;

/**
 * Restore IP Addresses
 * <p>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 *
 * @author ywk
 * @date 2020-03-19
 */
public class Q93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtracking(result, s, new ArrayList<>(4));
        return result;
    }

    private void backtracking(List<String> result, String s, List<String> list) {
        if ("".equals(s)) {
            return;
        }
        if (list.size() == 3) {
            if (s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1)) {
                return;
            }
            int i = Integer.parseInt(s);
            if (i < 256) {
                list.add(s);
                result.add(String.join(".", list));
                list.remove(3);
                return;
            }
        }
        if (s.charAt(0) == '0') {
            list.add("0");
            backtracking(result, s.substring(1), list);
            list.remove(list.size() - 1);
            return;
        }
        for (int i = 1; i < 4 && i < s.length(); i++) {
            String part = s.substring(0, i);
            if (Integer.parseInt(part) < 256) {
                list.add(part);
                backtracking(result, s.substring(i), list);
                list.remove(list.size() - 1);
            }
        }
    }
}
