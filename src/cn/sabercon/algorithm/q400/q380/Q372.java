package cn.sabercon.algorithm.q400.q380;

import java.util.Arrays;

/**
 * Super Pow
 *
 * Your task is to calculate a^b mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 *
 * Example 1:
 *
 * Input: a = 2, b = [3]
 * Output: 8
 * Example 2:
 *
 * Input: a = 2, b = [1,0]
 * Output: 1024
 *
 * @author ywk
 * @date 2020-04-28
 */
public class Q372 {

    public static int superPow(int a, int[] b) {
        // (a * b) % k = (a % k)(b % k) % k
        int length = b.length;
        if (length == 0) {
            return 1;
        }
        return pow(a, b[length - 1]) * pow(superPow(a, Arrays.copyOf(b, length - 1)), 10) % 1337;
    }

    private static int pow(int num, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return num % 1337;
        }
        if (exp == 2) {
            return (num % 1337) * (num % 1337) % 1337;
        }
        if (exp % 2 == 1) {
            return num % 1337 * pow(num, exp - 1) % 1337;
        }
        // (num^exp) % k = (num^(exp/2) * num^(exp/2)) % k = (num^(exp/2) % k) * (num^(exp/2) % k) % k
        return pow(pow(num, exp / 2), 2);
//        int ans = 1;
//        for (int i = 0; i < exp; i++) {
//            ans = num % 1337 * ans % 1337;
//        }
//        return ans;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 2));
    }
}
