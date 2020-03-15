package cn.sabercon.algorithm.q100.q60;

/**
 * Length of Last Word
 * <p>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 * <p>
 * Example:
 * Input: "Hello World"
 * Output: 5
 *
 * @author ywk
 * @date 2020-03-15
 */
public class Q58 {

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int length = 0;
        boolean start = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (start) {
                if (chars[i] == ' ') {
                    break;
                }
                length++;
            } else {
                if (chars[i] != ' ') {
                    start = true;
                    length++;
                }
            }
        }
        return length;
    }
}
