package cn.sabercon.algorithm.q300.q210;

/**
 * Implement Trie (Prefix Tree)
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 * <p>
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 * @author ywk
 * @date 2020-04-02
 */
public class Q208 {

    TrieNode head;

    /**
     * Initialize your data structure here.
     */
    public Q208() {
        head = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = head;
        for (int i = 0; i < word.length(); i++) {
            int key = word.charAt(i) - 'a';
            if (node.nextNodes[key] == null) {
                node.nextNodes[key] = new TrieNode();
            }
            if (i == word.length() - 1) {
                node.nextNodes[key].isPresent = true;
            }
            node = node.nextNodes[key];
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = head;
        for (int i = 0; i < word.length() - 1; i++) {
            int key = word.charAt(i) - 'a';
            if (node.nextNodes[key] == null) {
                return false;
            }
            node = node.nextNodes[key];
        }
        return node.nextNodes[word.charAt(word.length() - 1) - 'a'] != null &&node.nextNodes[word.charAt(word.length() - 1) - 'a'].isPresent;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = head;
        for (int i = 0; i < prefix.length(); i++) {
            int key = prefix.charAt(i) - 'a';
            if (node.nextNodes[key] == null) {
                return false;
            }
            node = node.nextNodes[key];
        }
        return true;
    }

    private class TrieNode {

        TrieNode() {
            nextNodes = new TrieNode[26];
        }

        boolean isPresent;

        TrieNode[] nextNodes;
    }
}
