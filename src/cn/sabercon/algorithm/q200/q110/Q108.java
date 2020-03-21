package cn.sabercon.algorithm.q200.q110;

/**
 * Convert Sorted Array to Binary Search Tree
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @author ywk
 * @date 2020-03-21
 */
public class Q108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int middle = begin + (end - begin) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = buildBST(nums, begin, middle - 1);
        node.right = buildBST(nums, middle + 1, end);
        return node;
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
