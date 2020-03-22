package cn.sabercon.algorithm.q200.q120;

/**
 * Distinct Subsequences
 *
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 *
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 *
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 *
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q115 {

    public int numDistinct(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[][] cache = new int[sChars.length][tChars.length];
        for (int i = 0; i < sChars.length; i++) {
            for (int j = 0; j < tChars.length; j++) {
                cache[i][j] = -1;
            }
        }
        return calcNumDistinct(sChars, 0, tChars, 0, cache);
    }

    private int calcNumDistinct(char[] sChars, int sIndex, char[] tChars, int tIndex, int[][] cache) {
        if (tIndex >= tChars.length) {
            return 1;
        }
        if (sChars.length - sIndex < tChars.length - tIndex) {
            return 0;
        }
        if (cache[sIndex][tIndex] != -1) {
            return cache[sIndex][tIndex];
        }
        for (int i = sIndex; i < sChars.length; i++) {
            if (sChars[i] == tChars[tIndex]) {
                int sum = calcNumDistinct(sChars, i + 1, tChars, tIndex, cache) + calcNumDistinct(sChars, i + 1, tChars, tIndex + 1, cache);
                cache[sIndex][tIndex] = sum;
                return sum;
            }
        }
        cache[sIndex][tIndex] = 0;
        return 0;
    }
}
