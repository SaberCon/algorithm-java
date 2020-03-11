package cn.sabercon.algorithm.q100.q40;

import java.util.HashSet;

/**
 * Sudoku Solver
 * <p>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy all of the following rules:
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * <p>
 * Empty cells are indicated by the character '.'.
 * <p>
 * Note:
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 *
 * @author ywk
 * @date 2020-03-11
 */
public class Q37 {

    public void solveSudoku(char[][] board) {
        HashSet[] rows = new HashSet[9];
        HashSet[] cols = new HashSet[9];
        HashSet[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            boxes[i] = new HashSet();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                rows[i].add(num);
                cols[j].add(num);
                boxes[(i / 3) * 3 + j / 3].add(num);
            }
        }
        for (char i = '1'; i < '1' + 9; i++) {
            backtracking(board, rows, cols, boxes, i, 0, 0);
        }
    }

    private boolean backtracking(char[][] board, HashSet[] rows, HashSet[] cols, HashSet[] boxes, char num, int i, int j) {
        if (i > 8) {
            return true;
        }
        if (board[i][j] != '.') {
            return backtracking(board, rows, cols, boxes, num, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1);
        }
        int boxIndex = (i / 3) * 3 + j / 3;
        if (rows[i].contains(num) || cols[j].contains(num) || boxes[boxIndex].contains(num)) {
            return false;
        }
        board[i][j] = num;
        rows[i].add(num);
        cols[j].add(num);
        boxes[(i / 3) * 3 + j / 3].add(num);
        for (char k = '1'; k < '1' + 9; k++) {
            if (backtracking(board, rows, cols, boxes, k, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1)) {
                return true;
            }
        }
        board[i][j] = '.';
        rows[i].remove(num);
        cols[j].remove(num);
        boxes[(i / 3) * 3 + j / 3].remove(num);
        return false;
    }
}
