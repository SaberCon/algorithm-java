package cn.sabercon.algorithm.q400.q390;

/**
 * First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 * @author ywk
 * @date 2020-04-29
 */
public class Q387 {

    public int firstUniqChar(String s) {
        int first = 0;
        int more = 0;
        for (char c : s.toCharArray()) {
            int bit = getBit(c);
            if ((first & bit) == 0) {
                first |= bit;
            } else {
                more |= bit;
            }
        }
        int unique = first ^ more;
        if (unique == 0) {
            return -1;
        }
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int bit = getBit(s.charAt(i));
            if ((bit ^ unique) < unique) {
                return i;
            }
        }
        return -1;
    }

    private int getBit(char c) {
        return 1 << (c - 'a');
    }

    public static void main(String[] args) {
        System.out.println(1 << 0);
    }
}
