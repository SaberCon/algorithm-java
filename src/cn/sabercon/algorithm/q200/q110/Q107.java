package cn.sabercon.algorithm.q200.q110;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Binary Tree Level Order Traversal II
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @author ywk
 * @date 2020-03-21
 */
public class Q107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>(1);
        if (root != null) {
            list.add(root);
        }
        build(result, list);
        return result;
    }

    private void build(List<List<Integer>> result, List<TreeNode> list) {
        if (list.size() == 0) {
            return;
        }
        List<TreeNode> nextList = new ArrayList<>();
        List<Integer> mapList = list.stream().peek(n -> {
            if (n.left != null) {
                nextList.add(n.left);
            }
            if (n.right != null) {
                nextList.add(n.right);
            }
        }).map(n -> n.val).collect(Collectors.toList());
        build(result, nextList);
        result.add(mapList);
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
