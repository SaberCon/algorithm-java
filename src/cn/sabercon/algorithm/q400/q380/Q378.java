package cn.sabercon.algorithm.q400.q380;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Kth Smallest Element in a Sorted Matrix
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n^2.
 *
 * @author ywk
 * @date 2020-04-29
 */
public class Q378 {

    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = row;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (heap.size() < k) {
                    heap.offer(matrix[i][j]);
                } else {
                    if (matrix[i][j] >= heap.peek()) {
                        col = j;
                    } else {
                        heap.poll();
                        heap.offer(matrix[i][j]);
                    }
                }
            }
        }
        return heap.poll();
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length - 1;
        int left = matrix[0][0], right = matrix[n][n];
        while(left < right){
            int mid = left + (right - left) / 2;
            int count = countNotMoreThanMid(matrix, mid, n);
            if(count < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private int countNotMoreThanMid(int[][] matrix, int mid, int n){
        int count = 0;
        int x = 0, y = n;
        while(x <= n && y >= 0){
            if(matrix[y][x] <= mid){
                count += y + 1;
                x++;
            }else{
                y--;
            }
        }
        return count;
    }
}
