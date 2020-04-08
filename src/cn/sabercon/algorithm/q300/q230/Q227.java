package cn.sabercon.algorithm.q300.q230;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Basic Calculator II
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 * <p>
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 * <p>
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 * <p>
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 *
 * @author ywk
 * @date 2020-04-08
 */
public class Q227 {

    public int calculate(String s) {
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Character> operators = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    num = num * 10 + s.charAt(i) - '0';
                }
                nums.add(num);
            } else {
                operators.add(c);
            }
        }
        while (!operators.isEmpty()) {
            calcFirst(nums, operators);
        }
        return nums.getFirst();
    }

    private void calcFirst(LinkedList<Integer> nums, LinkedList<Character> operators) {
        char operator = operators.pollFirst();
        if (operator == '*') {
            nums.addFirst(nums.pollFirst() * nums.pollFirst());
        }
        if (operator == '/') {
            nums.addFirst(nums.pollFirst() / nums.pollFirst());
        }
        if (operator == '+') {
            if (operators.isEmpty() || operators.getFirst().equals('+') || operators.getFirst().equals('-')) {
                nums.addFirst(nums.pollFirst() + nums.pollFirst());
            } else {
                Integer num = nums.pollFirst();
                calcFirst(nums, operators);
                operators.addFirst(operator);
                nums.addFirst(num);
                calcFirst(nums, operators);
            }
        }
        if (operator == '-') {
            if (operators.isEmpty() || operators.getFirst().equals('+') || operators.getFirst().equals('-')) {
                nums.addFirst(nums.pollFirst() - nums.pollFirst());
            } else {
                Integer num = nums.pollFirst();
                calcFirst(nums, operators);
                operators.addFirst(operator);
                nums.addFirst(num);
                calcFirst(nums, operators);
            }
        }
    }
}
