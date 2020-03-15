package cn.sabercon.algorithm.q100.q60;

import java.util.ArrayList;

/**
 * Permutation Sequence
 * <p>
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note:
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * <p>
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 * <p>
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 * @author ywk
 * @date 2020-03-15
 */
public class Q60 {

    public String getPermutation(int n, int k) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        StringBuilder builder = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        k--;
        for (int i = n; i > 0; i--) {
            factorial /= i;
            builder.append(list.remove(k / factorial));
            k %= factorial;
        }
        return builder.toString();
    }
}
