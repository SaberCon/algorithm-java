package cn.sabercon.algorithm.q400.q400;

import java.util.Arrays;

/**
 * 396. Rotate Function
 *
 * Given an array of integers A and let n to be its length.
 *
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 *
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 *
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 *
 * Note:
 * n is guaranteed to be less than 105.
 *
 * Example:
 *
 * A = [4, 3, 2, 6]
 *
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 *
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 *
 * @author SaberCon
 * @date 2020-05-28
 */
public class Q396 {

    public int maxRotateFunction(int[] A) {
        int length = A.length;
        int sum = Arrays.stream(A).sum();
        int last = 0;
        for (int i = 0; i < length; i++) {
            last += A[i] * i;
        }
        int max = last;
        for (int i = 0; i < length - 1; i++) {
            last = last - sum + A[i] * length;
            max = Math.max(max, last);
        }
        return max;
    }
}
