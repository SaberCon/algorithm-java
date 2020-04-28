package cn.sabercon.algorithm.q400.q380;

/**
 * Guess Number Higher or Lower II
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 *
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 *
 * Example:
 *
 * n = 10, I pick 8.
 *
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 *
 * Game over. 8 is the number I picked.
 *
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 *
 * @author ywk
 * @date 2020-04-28
 */
public class Q375 {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n][n];
        return calcDP(dp, 0, n - 1);
    }

    private int calcDP(int[][] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int min = Integer.MAX_VALUE;
        for (int i = start + (end - start) / 2; i < end; i++) {
            min = Math.min(min, Math.max(calcDP(dp, start, i - 1), calcDP(dp, i + 1, end)) + i + 1);
        }
        dp[start][end] = min;
        return min;
    }
}
