package cn.sabercon.algorithm.q200.q130;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Binary Tree Maximum Path Sum
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q124 {

    public int maxPathSum(TreeNode root) {
        AtomicInteger result = new AtomicInteger(root.val);
        getMax(root, result);
        return result.get();
    }

    private int getMax(TreeNode root, AtomicInteger result) {
        if (root == null) {
            return 0;
        }
        int leftMax = getMax(root.left, result);
        int rightMax = getMax(root.right, result);
        int max = root.val + Math.max(Math.max(0, leftMax + rightMax), Math.max(leftMax, rightMax));
        if (max > result.get()) {
            result.set(max);
        }
        return root.val + Math.max(0, Math.max(leftMax, rightMax));
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
