package cn.sabercon.algorithm.q400.q320;

/**
 * Maximum Product of Word Lengths
 * <p>
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * Example 2:
 * <p>
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * Example 3:
 * <p>
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 *
 * @author ywk
 * @date 2020-04-22
 */
public class Q318 {

    public int maxProduct(String[] words) {
        int length = words.length;
        int[] wordMap = new int[length];
        for (int i = 0; i < length; i++) {
            for (char c : words[i].toCharArray()) {
                int bit = 1 << (c - 'a');
                if ((bit & wordMap[i]) == 0) {
                    wordMap[i] += bit;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((wordMap[i] & wordMap[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}
