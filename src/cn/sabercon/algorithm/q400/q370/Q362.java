package cn.sabercon.algorithm.q400.q370;

/**
 * Max Sum of Rectangle No Larger Than K
 * <p>
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.
 * <p>
 * Example:
 * <p>
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
 *              and 2 is the max number no larger than k (k = 2).
 * Note:
 * <p>
 * The rectangle inside the matrix must have an area > 0.
 * What if the number of rows is much larger than the number of columns?
 *
 * @author ywk
 * @date 2020-04-28
 */
public class Q362 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            int[] colSums = new int[col];
            for (int j = i; j < row; j++) {
                for (int l = 0; l < col; l++) {
                    colSums[l] += matrix[j][l];
                }
                max = Math.max(max, dpMax(colSums, k));
                if (max == k) {
                    return k;
                }
            }
        }
        return max;
    }

    private int dpMax(int[] colSums, int k) {
        int max = Integer.MIN_VALUE;
        int lastSum = 0;
        for (int sum : colSums) {
            lastSum += sum;
            if (lastSum == k) {
                return k;
            }
            if (lastSum > k) {
                max = lastSum;
                break;
            }
            max = Math.max(max, lastSum);
            if (lastSum < 0) {
                lastSum = 0;
            }
        }
        if (max > k) {
            max = Integer.MIN_VALUE;
            for (int l = 0; l < colSums.length; l++) {
                int sum = 0;
                for (int r = l; r < colSums.length; r++) {
                    sum += colSums[r];
                    if (sum > max && sum <= k) max = sum;
                    if (max == k) return k;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Q362 q362 = new Q362();
        System.out.println(q362.maxSumSubmatrix(new int[][]{{2,2,-1}}, 2));
    }
}
