package cn.sabercon.algorithm.q200.q140;

/**
 * Palindrome Partitioning II
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q132 {

    public int minCut(String s) {
        Integer[] cache = new Integer[s.length()];
        return min(cache, s, 0);
    }

    private int min(Integer[] cache, String s, int index) {
        if (cache[index] != null) {
            return cache[index];
        }
        int min = Integer.MAX_VALUE;
        if (isPalindrome(s, index, s.length() - 1)) {
            min = 0;
        } else if (isPalindrome(s, index, s.length() - 2)) {
            min = 1;
        } else {
            for (int i = index; i < s.length() - 2; i++) {
                if (isPalindrome(s, index, i)) {
                    int nextMin = min(cache, s, i + 1);
                    min = Math.min(min, nextMin + 1);
                }
            }
        }
        cache[index] = min;
        return min;
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Q132 q132 = new Q132();
        System.out.println(q132.minCut("cdd"));
    }
}
