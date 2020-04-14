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
            return "Zero";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1000000000; i >= 1; i /= 1000) {
            if (num / i != 0) {
                builder.append(getFirstAndSecondAndThirdNum(num / i)).append(getThousandNum(i));
            }
            num = num % i;
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    private String getThousandNum(int n) {
        switch (n) {
            case 1:
                return "";
            case 1000:
                return "Thousand ";
            case 1000000:
                return "Million ";
            case 1000000000:
                return "Billion ";
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }
    }

    private String getFirstNum(int n) {
        switch (n) {
            case 0:
                return "";
            case 1:
                return "One ";
            case 2:
                return "Two ";
            case 3:
                return "Three ";
            case 4:
                return "Four ";
            case 5:
                return "Five ";
            case 6:
                return "Six ";
            case 7:
                return "Seven ";
            case 8:
                return "Eight ";
            case 9:
                return "Nine ";
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }
    }

    private String getSecondNum(int n) {
        switch (n) {
            case 0:
                return "";
            case 2:
                return "Twenty ";
            case 3:
                return "Thirty ";
            case 4:
                return "Forty ";
            case 5:
                return "Fifty ";
            case 6:
                return "Sixty ";
            case 7:
                return "Seventy ";
            case 8:
                return "Eighty ";
            case 9:
                return "Ninety ";
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }
    }

    private String getFirstAndSecondNum(int n) {
        switch (n) {
            case 10:
                return "Ten ";
            case 11:
                return "Eleven ";
            case 12:
                return "Twelve ";
            case 13:
                return "Thirteen ";
            case 14:
                return "Fourteen ";
            case 15:
                return "Fifteen ";
            case 16:
                return "Sixteen ";
            case 17:
                return "Seventeen ";
            case 18:
                return "Eighteen ";
            case 19:
                return "Nineteen ";
            default:
                return getSecondNum(n / 10) + getFirstNum(n % 10);
        }
    }

    private String getFirstAndSecondAndThirdNum(int n) {
        if (n / 100 != 0) {
            return getFirstNum(n / 100) + "Hundred " + getFirstAndSecondNum(n % 100);
        } else {
            return getFirstAndSecondNum(n);
        }
    }
}
