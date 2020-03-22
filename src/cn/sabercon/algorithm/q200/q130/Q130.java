package cn.sabercon.algorithm.q200.q130;

/**
 * Surrounded Regions
 * <p>
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q130 {

    public void solve(char[][] board) {
        if (board.length < 3 || board[0].length < 3) {
            return;
        }
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][0] == 'O' && board[i][1] == 'O') {
                mark(board, i, 1);
            }
            if (board[i][board[0].length - 1] == 'O' && board[i][board[0].length - 2] == 'O') {
                mark(board, i, board[0].length - 2);
            }
        }
        for (int j = 1; j < board[0].length - 1; j++) {
            if (board[0][j] == 'O' && board[1][j] == 'O') {
                mark(board, 1, j);
            }
            if (board[board.length - 1][j] == 'O' && board[board.length - 2][j] == 'O') {
                mark(board, board.length - 2, j);
            }
        }
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void mark(char[][] board, int i, int j) {
        board[i][j] = 'M';
        if (i > 1 && board[i - 1][j] == 'O') {
            mark(board, i - 1, j);
        }
        if (j > 1 && board[i][j - 1] == 'O') {
            mark(board, i, j - 1);
        }
        if (i < board.length - 2 && board[i + 1][j] == 'O') {
            mark(board, i + 1, j);
        }
        if (j < board[0].length - 2 && board[i][j + 1] == 'O') {
            mark(board, i, j + 1);
        }
    }
}
