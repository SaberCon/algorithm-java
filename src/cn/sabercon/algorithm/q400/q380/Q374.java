package cn.sabercon.algorithm.q400.q380;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Guess Number Higher or Lower
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * Example :
 *
 * Input: n = 10, pick = 6
 * Output: 6
 *
 * @author ywk
 * @date 2020-04-28
 */
public class Q374 {

    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (true) {
            int middle = start + (end - start) / 2;
            int ret = guess(middle);
            if (ret == 0) {
                return middle;
            }
            if (ret < 0) {
                end = middle - 1;
            }
            if (ret > 0) {
                start = middle + 1;
            }
        }
    }

    /**
     * Forward declaration of guess API.
     * @param  num      your guess
     * @return 	        -1 if num is lower than the guess number
     *			        1 if num is higher than the guess number
     *                  otherwise return 0
     */
    private int guess(int num) {
        return ThreadLocalRandom.current().nextInt(3) - 1;
    }
}
