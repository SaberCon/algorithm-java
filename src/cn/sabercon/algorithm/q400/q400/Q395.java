package cn.sabercon.algorithm.q400.q400;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 * <p>
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "aaabb", k = 3
 * <p>
 * Output:
 * 3
 * <p>
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * <p>
 * Input:
 * s = "ababbc", k = 2
 * <p>
 * Output:
 * 5
 * <p>
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
 * @author SaberCon
 * @date 2020-05-28
 */
public class Q395 {

    int ans;

    String str;

    int count;

    public int longestSubstring(String s, int k) {
        if (k == 0) {
            return s.length();
        }
        ans = 0;
        str = s;
        count = k;
        findLongestSubstring(0, s.length());
        return ans;
    }

    private void findLongestSubstring(int start, int end) {
        if (end - start <= ans) {
            return;
        }
        int[] counts = new int[26];
        for (int i = start; i < end; i++) {
            counts[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && counts[i] < count) {
                int left = start;
                char c = (char) (i + 'a');
                for (int j = start; j < end; j++) {
                    if (str.charAt(j) == c) {
                        findLongestSubstring(left, j);
                        left = j + 1;
                    }
                }
                findLongestSubstring(left, end);
                return;
            }
        }
        ans = end - start;
    }
}
