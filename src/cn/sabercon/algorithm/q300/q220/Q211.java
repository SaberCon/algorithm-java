package cn.sabercon.algorithm.q300.q220;

/**
 * Add and Search Word - Data structure design
 *
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 * @author ywk
 * @date 2020-04-03
 */
public class Q211 {

    TrieNode head;

    /** Initialize your data structure here. */
    public Q211() {
        head = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word.length() == 0) {
            return false;
        }
        return search(head, word, 0);
    }

    private boolean search(TrieNode head, String word, int index) {
        if (index == word.length()) {
            return head.isPresent;
        }
        if (word.charAt(index) == '.') {
            for (TrieNode node : head.nextNodes) {
                if (node != null && search(node, word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode node = head.nextNodes[word.charAt(index) - 'a'];
            if (node == null) {
                return false;
            }
            return search(node, word, index + 1);
        }
    }

    private class TrieNode {

        TrieNode() {
            nextNodes = new TrieNode[26];
        }

        boolean isPresent;

        TrieNode[] nextNodes;
    }
}
