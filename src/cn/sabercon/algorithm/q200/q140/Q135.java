package cn.sabercon.algorithm.q200.q140;

import java.util.Arrays;

/**
 * Candy
 * <p>
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 * <p>
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 *
 * @author ywk
 * @date 2020-03-23
 */
public class Q135 {

    public int candy(int[] ratings) {
        int[] allos = new int[ratings.length];
        allos[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                allos[i] = allos[i - 1] + 1;
            } else {
                allos[i] = 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                allos[i] = Math.max(allos[i], allos[i + 1] + 1);
            }
        }
        return Arrays.stream(allos).sum();
    }
}
