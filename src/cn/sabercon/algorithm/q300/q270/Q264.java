package cn.sabercon.algorithm.q300.q270;

/**
 * Ugly Number II
 * <p>
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * <p>
 * Example:
 * <p>
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:  
 * <p>
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 *
 * @author ywk
 * @date 2020-04-13
 */
public class Q264 {

    int[] uglies = new int[1690];

    {
        uglies[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < 1690; i++) {
            int min2 = uglies[i2] * 2;
            int min3 = uglies[i3] * 3;
            int min5 = uglies[i5] * 5;
            uglies[i] = Math.min(Math.min(min2, min3), min5);
            if (uglies[i] == min2) {
                i2++;
            }
            if (uglies[i] == min3) {
                i3++;
            }
            if (uglies[i] == min5) {
                i5++;
            }
        }
    }

    public int nthUglyNumber(int n) {
        return uglies[n - 1];
    }
}
