package cn.sabercon.algorithm.q200.q130;

import java.util.BitSet;
import java.util.HashSet;
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
        wordList.add(beginWord);
        boolean[][] transforms = new boolean[wordList.size()][wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (isTransformable(wordList.get(j), wordList.get(i))) {
                    transforms[i][j] = true;
                }
            }
        }
        int index = wordList.indexOf(endWord);
        if (index < 0) {
            return 0;
        }
        BitSet bitSet = new BitSet(wordList.size());
        bitSet.set(index);
        HashSet<Integer> set = new HashSet<>();
        set.add(index);
        int length = 1;
        while (!set.isEmpty()) {
            HashSet<Integer> temp = new HashSet<>();
            for (Integer curIndex : set) {
                if (transforms[wordList.size() - 1][curIndex]) {
                    return length + 1;
                }
                for (int i = 0; i < wordList.size() - 1; i++) {
                    if (!bitSet.get(i) && (transforms[i][curIndex] || transforms[curIndex][i])) {
                        bitSet.set(i);
                        temp.add(i);
                    }
                }
            }
            length++;
            set = temp;
        }
        return 0;
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
