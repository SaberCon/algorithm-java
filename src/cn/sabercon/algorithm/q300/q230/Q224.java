package cn.sabercon.algorithm.q300.q230;

import java.util.Stack;

/**
 * Basic Calculator
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * <p>
 * Example 1:
 * <p>
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 * <p>
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 * <p>
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 *
 * @author ywk
 * @date 2020-04-08
 */
public class Q224 {

    public int calculate(String s) {
        Stack<Character> operators = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    num = num * 10 + s.charAt(i) - '0';
                }
                if (operators.isEmpty() || operators.peek() == '(') {
                    nums.push(num);
                } else if (operators.peek() == '+') {
                    operators.pop();
                    nums.push(nums.pop() + num);
                } else if (operators.pop() == '-') {
                    nums.push(nums.pop() - num);
                }
            } else if (c == ')') {
                operators.pop();
                while (!operators.isEmpty() && operators.peek() != '(') {
                    Character operator = operators.pop();
                    if (operator == '+') {
                        nums.push(nums.pop() + nums.pop());
                    } else {
                        nums.push(-nums.pop() + nums.pop());
                    }
                }
            } else if (c == '(' || c == '+' || c == '-') {
                operators.push(c);
            }
        }
        return nums.pop();
    }
}
