package cn.sabercon.algorithm.q300.q210;

/**
 * Count Primes
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * @author ywk
 * @date 2020-03-31
 */
public class Q204 {

    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isPrime(int num) {
        boolean prime = true;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return prime;
    }
}
