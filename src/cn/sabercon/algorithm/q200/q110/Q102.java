package cn.sabercon.algorithm.q200.q110;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author ywk
 * @date 2020-03-21
 */
public class Q102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        if (root != null) {
            list.add(root);
        }
        while (list.size() > 0) {
            List<TreeNode> temp = new ArrayList<>();
            result.add(list.stream().peek(n -> {
                if (n.left != null) {
                    temp.add(n.left);
                }
                if (n.right != null) {
                    temp.add(n.right);
                }
            }).map(n -> n.val).collect(Collectors.toList()));
            list = temp;
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
