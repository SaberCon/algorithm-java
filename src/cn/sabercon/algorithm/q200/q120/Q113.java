package cn.sabercon.algorithm.q200.q120;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum II
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        findPathSum(result, root, sum, new ArrayList<>());
        return result;
    }

    private void findPathSum(List<List<Integer>> result, TreeNode node, int sum, ArrayList<Integer> list) {
        if (node.left == null && node.right == null && sum == node.val) {
            ArrayList<Integer> clone = (ArrayList<Integer>) list.clone();
            clone.add(sum);
            result.add(clone);
        }
        list.add(node.val);
        if (node.left != null) {
            findPathSum(result, node.left, sum - node.val, list);
        }
        if (node.right != null) {
            findPathSum(result, node.right, sum - node.val, list);
        }
        list.remove(list.size() - 1);
    }

    public static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
