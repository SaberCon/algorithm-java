package cn.sabercon.algorithm.q300.q240;

/**
 * Search a 2D Matrix II
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 *
 * @author ywk
 * @date 2020-04-11
 */
public class Q240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return binarySearch(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private boolean binarySearch(int[][] matrix, int target, int x1, int x2, int y1, int y2) {
        if (x1 < 0 || x2 == matrix.length || y1 < 0 || y2 == matrix[0].length || x1 > x2 || y1 > y2) {
            return false;
        }
        int middleX = x2 - (x2 - x1) / 2;
        int middleY = y2 - (y2 - y1) / 2;
        if (matrix[middleX][middleY] == target) {
            return true;
        }
        if (matrix[middleX][middleY] > target) {
            if (binarySearch(matrix, target, x1, x2, y1, middleY - 1)
                    || binarySearch(matrix, target, x1, middleX - 1, middleY, y2)) {
                return true;
            }
        }
        if (matrix[middleX][middleY] < target) {
            if (binarySearch(matrix, target, x1, x2, middleY + 1, y2)
                    || binarySearch(matrix, target, middleX + 1, x2, y1, middleY)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        Q240 q240 = new Q240();
        System.out.println(q240.searchMatrix(matrix, 5));
    }
}
