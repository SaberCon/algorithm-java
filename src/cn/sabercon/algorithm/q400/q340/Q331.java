package cn.sabercon.algorithm.q400.q340;

import java.util.Stack;

/**
 * Verify Preorder Serialization of a Binary Tree
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as #.
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * <p>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree.
 * Find an algorithm without reconstructing the tree.
 * <p>
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p>
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * <p>
 * Example 1:
 * <p>
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * Example 2:
 * <p>
 * Input: "1,#"
 * Output: false
 * Example 3:
 * <p>
 * Input: "9,#,#,1"
 * Output: false
 *
 * @author ywk
 * @date 2020-04-26
 */
public class Q331 {

    public static boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String node : nodes) {
            stack.push(node);
            while (stack.size() > 2 && "#".equals(stack.peek())) {
                stack.pop();
                if ("#".equals(stack.peek())) {
                    stack.pop();
                    if ("#".equals(stack.peek())) {
                        return false;
                    }
                    stack.pop();
                    stack.push("#");
                } else {
                    stack.push("#");
                    break;
                }

            }
        }
        return stack.size() == 1 && "#".equals(stack.peek());
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
