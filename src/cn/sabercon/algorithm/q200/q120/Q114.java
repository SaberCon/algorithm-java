package cn.sabercon.algorithm.q200.q120;

/**
 * Flatten Binary Tree to Linked List
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q114 {

    public void flatten(TreeNode root) {
        if (root != null) {
            link(root);
        }
    }

    private TreeNode link(TreeNode node) {
        if (node.left == null) {
            if (node.right == null) {
                return node;
            } else {
                return link(node.right);
            }
        }
        if (node.right == null) {
            node.right = node.left;
            node.left = null;
            return link(node.right);
        }
        TreeNode left = link(node.left);
        TreeNode right = link(node.right);
        left.right = node.right;
        node.right = node.left;
        node.left = null;
        return right;
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
