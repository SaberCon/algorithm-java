package cn.sabercon.algorithm.q200.q130;

/**
 * Valid Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q125 {

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        while (begin < end) {
            if (notValid(chars[begin])) {
                begin++;
            } else if (notValid(chars[end])) {
                end--;
            } else {
                if (Character.toUpperCase(chars[begin]) != Character.toUpperCase(chars[end])) {
                    return false;
                }
                begin++;
                end--;
            }
        }
        return true;
    }

    private boolean notValid(char aChar) {
        return (aChar < '0' || aChar > '9') && (aChar < 'a' || aChar > 'z') && (aChar < 'A' || aChar > 'Z');
    }
}
