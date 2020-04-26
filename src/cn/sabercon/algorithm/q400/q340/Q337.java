package cn.sabercon.algorithm.q400.q340;

import java.util.HashMap;
import java.util.Map;

/**
 * House Robber III
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 * @author ywk
 * @date 2020-04-26
 */
public class Q337 {

    Map<TreeNode, Integer> trueMap;

    Map<TreeNode, Integer> falseMap;

    public int rob(TreeNode root) {
        trueMap = new HashMap<>();
        falseMap = new HashMap<>();
        return Math.max(rob(root, true), rob(root, false));
    }

    private int rob(TreeNode node, boolean robbed) {
        if (node == null) {
            return 0;
        }
        if (robbed) {
            if (!trueMap.containsKey(node)) {
                trueMap.put(node, node.val + rob(node.left, false) + rob(node.right, false));
            }
            return trueMap.get(node);
        } else {
            if (!falseMap.containsKey(node)) {
                falseMap.put(node, Math.max(rob(node.left, true), rob(node.left, false)) + Math.max(rob(node.right, true), rob(node.right, false)));
            }
            return falseMap.get(node);
        }
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
