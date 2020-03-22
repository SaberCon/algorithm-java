package cn.sabercon.algorithm.q200.q130;

import java.util.List;

/**
 * Word Ladder
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = 0;
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (isTransformable(beginWord, word)) {
                if (endWord.equals(word)) {
                    return 2;
                }
                int nextLength = ladderLength(word, endWord, wordList);
                if (nextLength > 0) {
                    length = length == 0 ? nextLength : Math.min(length, nextLength);
                }
            }
        }
        return length == 0 ? 0 : length + 1;
    }

    public boolean isTransformable(String str1, String str2) {
        boolean transformable = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (transformable) {
                    return false;
                }
                transformable = true;
            }
        }
        return transformable;
    }
}
