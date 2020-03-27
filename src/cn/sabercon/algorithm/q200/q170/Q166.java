package cn.sabercon.algorithm.q200.q170;

import java.util.HashMap;

/**
 * Fraction to Recurring Decimal
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 *
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 *
 * @author ywk
 * @date 2020-03-27
 */
public class Q166 {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            builder.append("-");
        }
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        builder.append(n / d).append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        int index = builder.length();
        long remainder = (n % d) * 10;
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                builder.insert(map.get(remainder), "(");
                builder.append(")");
                return builder.toString();
            }
            map.put(remainder, index);
            index++;
            builder.append(remainder / d);
            remainder = (remainder % d) * 10;
        }
        if (builder.charAt(builder.length() - 1) == '.') {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }
}
