package cn.sabercon.algorithm.q300.q280;

import java.util.LinkedList;

/**
 * Integer to English Words
 * <p>
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * <p>
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * <p>
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 * <p>
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 * @author ywk
 * @date 2020-04-13
 */
public class Q273 {

    public String numberToWords(int num) {
        if (num == 0) {
            return "zero";
        }
        LinkedList<String> ans = new LinkedList<>();
        for (int i = 0; num > 0; i++) {
            num = num % 10;
            num = num / 10;
        }
        return ans.toString();
    }

    private String getNum(int n) {
        switch (n) {
            case 0:
                return "";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }
    }
}
