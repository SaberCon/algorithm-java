package cn.sabercon.algorithm.q100.q80;

/**
 * Search a 2D Matrix
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Example 1:
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * <p>
 * Example 2:
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 *
 * @author ywk
 * @date 2020-03-17
 */
public class Q74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int begin = 0;
        int end = matrix.length - 1;
        while (end - begin > 1) {
            int middle = begin + (end - begin) / 2;
            if (matrix[middle][0] == target) {
                return true;
            } else if (matrix[middle][0] > target) {
                end = middle;
            } else {
                begin = middle;
            }
        }
        if (matrix[begin][0] == target || matrix[end][0] == target) {
            return true;
        }
        if (matrix[begin][0] > target) {
            return false;
        }
        int row = matrix[end][0] < target ? end : begin;
        begin = 0;
        end = matrix[0].length - 1;
        while (end - begin > 1) {
            int middle = begin + (end - begin) / 2;
            if (matrix[row][middle] == target) {
                return true;
            } else if (matrix[row][middle] > target) {
                end = middle;
            } else {
                begin = middle;
            }
        }
        return matrix[row][begin] == target || matrix[row][end] == target;
    }
}
