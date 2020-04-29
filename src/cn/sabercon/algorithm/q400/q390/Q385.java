package cn.sabercon.algorithm.q400.q390;

import java.util.List;
import java.util.Stack;

/**
 * Mini Parser
 * <p>
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Note: You may assume that the string is well-formed:
 * <p>
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * Example 1:
 * <p>
 * Given s = "324",
 * <p>
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 * <p>
 * Given s = "[123,[456,[789]]]",
 * <p>
 * Return a NestedInteger object containing a nested list with 2 elements:
 * <p>
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 * i.  An integer containing value 456.
 * ii. A nested list with one element:
 * a. An integer containing value 789.
 *
 * @author ywk
 * @date 2020-04-29
 */
public class Q385 {

    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();
        int num = 0;
        boolean negative = false;
        boolean numValid = false;
        NestedInteger current = null;
        for (char c : s.toCharArray()) {
            if (c == '-') {
                negative = true;
            }
            if (c <= '9' && c >= '0') {
                if (negative) {
                    num = 10 * num - c + '0';
                } else {
                    num = 10 * num + c - '0';
                }
                numValid = true;
            }
            if (c == ',' && numValid) {
                stack.peek().add(new NestedInteger(num));
                num = 0;
                negative = false;
                numValid = false;
            }
            if (c == '[') {
                current = new NestedInteger();
                if (!stack.isEmpty())
                    stack.peek().add(current);
                stack.push(current);
            }
            if (c == ']') {
                current = stack.pop();
                if (numValid) {
                    current.add(new NestedInteger(num));
                    num = 0;
                    negative = false;
                    numValid = false;
                }
            }
        }
        if (numValid) {
            return new NestedInteger(num);
        }
        return current;
    }

    public static class NestedInteger {
        // Constructor initializes an empty nested list.
        NestedInteger() {
        }

        // Constructor initializes a single integer.
        NestedInteger(int value) {
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger() {
            return null;
        }

        // Set this NestedInteger to hold a single integer.
        void setInteger(int value) {
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        void add(NestedInteger ni) {
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList() {
            return null;
        }
    }
}
