package cn.sabercon.algorithm.q100.q100;

/**
 * Interleaving String
 * <p>
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example 1:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * <p>
 * Example 2:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 *
 * @author ywk
 * @date 2020-03-19
 */
public class Q97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[] dps = new boolean[s2.length() + 1];
        for (int i = -1; i < s1.length(); i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                dps[j] = (j > 0 && dps[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j)) || (i > -1 && dps[j] && s1.charAt(i) == s3.charAt(i + j));
                if (i == -1 && j == 0) {
                    dps[j] = true;
                }
            }
        }
        return dps[dps.length - 1];
    }
}
