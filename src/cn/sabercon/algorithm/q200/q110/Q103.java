package cn.sabercon.algorithm.q200.q110;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Zigzag Level Order Traversal
 * <p>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * @author ywk
 * @date 2020-03-21
 */
public class Q103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        boolean reverse = false;
        while (!stack.isEmpty()) {
            Stack<TreeNode> temp = new Stack<>();
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (reverse) {
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                    if (node.left != null) {
                        temp.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        temp.add(node.left);
                    }
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                }
                list.add(node.val);
            }
            result.add(list);
            stack = temp;
            reverse = !reverse;
        }
        return result;
    }

    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }
}
