package cn.sabercon.algorithm.q300.q220;

import java.util.*;

/**
 * Word Search II
 * <p>
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 *  
 * <p>
 * Example:
 * <p>
 * Input:
 * board = [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * <p>
 * Output: ["eat","oath"]
 *  
 * <p>
 * Note:
 * <p>
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 *
 * @author ywk
 * @date 2020-04-03
 */
public class Q212 {

    public List<String> findWords(char[][] board, String[] words) {
        WordDictionary dictionary = new WordDictionary();
        Arrays.stream(words).forEach(dictionary::addWord);
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                match(ans, dictionary.head, board, i, j, "", new boolean[board.length][board[0].length]);
            }
        }
        return new ArrayList<>(ans);
    }

    private void match(Set<String> ans, WordDictionary.TrieNode node, char[][] board, int i, int j, String prefix, boolean[][] marks) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || marks[i][j]) {
            return;
        }
        node = node.nextNodes[board[i][j] - 'a'];
        if (node == null) {
            return;
        }
        prefix += board[i][j];
        if (node.isPresent) {
            ans.add(prefix);
        }
        marks[i][j] = true;
        match(ans, node, board, i + 1, j, prefix, marks);
        match(ans, node, board, i - 1, j, prefix, marks);
        match(ans, node, board, i, j + 1, prefix, marks);
        match(ans, node, board, i, j - 1, prefix, marks);
        marks[i][j] = false;

    }

    private static class WordDictionary {

        TrieNode head;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            head = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode node = head;
            for (int i = 0; i < word.length(); i++) {
                int key = word.charAt(i) - 'a';
                if (node.nextNodes[key] == null) {
                    node.nextNodes[key] = new TrieNode();
                }
                node = node.nextNodes[key];
            }
            node.isPresent = true;
        }

        /**
         * Returns if the word is in the data structure.
         */
        public boolean search(String word) {
            TrieNode node = head;
            for (int i = 0; i < word.length(); i++) {
                TrieNode next = node.nextNodes[word.charAt(i) - 'a'];
                if (next == null) {
                    return false;
                }
                node = next;
            }
            return node.isPresent;
        }

        private class TrieNode {

            TrieNode() {
                nextNodes = new TrieNode[26];
            }

            boolean isPresent;

            TrieNode[] nextNodes;
        }

    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("fuck");
        dictionary.addWord("shit");
        dictionary.addWord("mother");
        System.out.println(dictionary.search("fucks"));
        System.out.println(dictionary.search("fuck"));
        System.out.println(dictionary.search("mothers"));
        System.out.println(dictionary.search("shit"));
        System.out.println(dictionary.search("yellow"));
    }
}
