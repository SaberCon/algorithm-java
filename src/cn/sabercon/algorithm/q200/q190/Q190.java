package cn.sabercon.algorithm.q200.q190;

import java.util.HashMap;
import java.util.Map;

/**
 * Reverse Bits
 * <p>
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
 * so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * <p>
 * Example 2:
 * <p>
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293,
 * so return 3221225471 which its binary representation is 10111111111111111111111111111111. 
 * <p>
 * Note:
 * <p>
 * Note that in some languages such as Java, there is no unsigned integer type.
 * In this case, both input and output will be given as signed integer type and should not affect your implementation,
 * as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore,
 * in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 * <p>
 * Follow up:
 * If this function is called many times, how would you optimize it?
 *
 * @author ywk
 * @date 2020-03-29
 */
public class Q190 {

    private static final Map<Integer, Integer> resultMap = new HashMap<>();

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (resultMap.containsKey(n)) {
            return resultMap.get(n);
        }
        int ans = 0;
        for (int i = 0; i < 16; i++) {
            ans += (n & (1 << i)) << (31 - i * 2);
            ans += (n & (Integer.MIN_VALUE >>> i)) >>> (31 - i * 2);
        }
        resultMap.put(n, ans);
        resultMap.put(ans, n);
        return ans;
    }

    public static void main(String[] args) {
        Q190 q190 = new Q190();
        System.out.println(Integer.toUnsignedString(q190.reverseBits(0b11110001111111111111111111111101)));
    }
}
