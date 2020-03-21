package cn.sabercon.algorithm.q200.q110;

import java.util.Arrays;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author ywk
 * @date 2020-03-21
 */
public class Q105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preIndex, int[] inorder, int inBegin, int inEnd) {
        if (inEnd < inBegin) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex]);
        int i;
        for (i = inBegin; i <= inEnd; i++) {
            if (preorder[preIndex] == inorder[i]) {
                break;
            }
        }
        node.left = build(preorder, preIndex + 1, inorder, inBegin, i - 1);
        node.right = build(preorder, preIndex + 1 + i - inBegin, inorder, i + 1, inEnd);
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
