package cn.sabercon.algorithm.q200.q140;

/**
 * Single Number II
 * <p>
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 *
 * @author ywk
 * @date 2020-03-23
 */
public class Q137 {

    public int singleNumber(int[] nums) {
        int once = 0;
        int twice = 0;
        // todo 理解できない
        for (int num : nums) {
            once = ~twice & (once ^ num);
            twice = ~once & (twice ^ num);
        }
        return once;
    }
}
