package cn.sabercon.algorithm.q100.q80;

import java.util.BitSet;

/**
 * Word Search
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * Example:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * <p>
 * Constraints:
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * @author ywk
 * @date 2020-03-18
 */
public class Q79 {

    public boolean exist(char[][] board, String word) {
        BitSet set = new BitSet();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtracking(board, word, set, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, BitSet set, int row, int col) {
        if ("".equals(word)) {
            return true;
        }
        int key = row * 1000 + col;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || set.get(key) || board[row][col] != word.charAt(0)) {
            return false;
        }
        set.set(key);
        if (backtracking(board, word.substring(1), set, row + 1, col)) {
            return true;
        }
        if (backtracking(board, word.substring(1), set, row - 1, col)) {
            return true;
        }
        if (backtracking(board, word.substring(1), set, row, col + 1)) {
            return true;
        }
        if (backtracking(board, word.substring(1), set, row, col - 1)) {
            return true;
        }
        set.set(key, false);
        return false;
    }
}
