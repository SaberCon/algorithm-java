package cn.sabercon.algorithm.q100.q100;

/**
 * Validate Binary Search Tree
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * Example 1:
 * 2
 * / \
 * 1   3
 * Input: [2,1,3]
 * Output: true
 * <p>
 * Example 2:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * @author ywk
 * @date 2020-03-20
 */
public class Q98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValid(root.left, Long.MIN_VALUE, root.val) && isValid(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        return node.val > left && node.val < right && isValid(node.left, left, node.val) && isValid(node.right, node.val, right);
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
