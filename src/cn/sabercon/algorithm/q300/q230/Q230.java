package cn.sabercon.algorithm.q300.q230;

/**
 * Kth Smallest Element in a BST
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 * @author ywk
 * @date 2020-04-09
 */
public class Q230 {

    public int kthSmallest(TreeNode root, int k) {
        Integer[] ans = new Integer[1];
        findKthSmallest(root, 0, k, ans);
        return ans[0];
    }

    private int findKthSmallest(TreeNode root, int index, int k, Integer[] ans) {
        if (ans[0] != null) {
            return 0;
        }
        if (root == null) {
            return index;
        }
        index = findKthSmallest(root.left, index, k, ans) + 1;
        if (ans[0] != null) {
            return 0;
        }
        if (index == k) {
            ans[0] = root.val;
            return 0;
        }
        return findKthSmallest(root.right, index, k, ans);
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
