package cn.sabercon.algorithm.q200.q110;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
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
public class Q106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int postIndex, int[] inorder, int inBegin, int inEnd) {
        if (inEnd < inBegin) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postIndex]);
        int i;
        for (i = inBegin; i <= inEnd; i++) {
            if (postorder[postIndex] == inorder[i]) {
                break;
            }
        }
        node.right = build(postorder, postIndex - 1, inorder, i + 1, inEnd);
        node.left = build(postorder, postIndex - 1 - inEnd + i, inorder, inBegin, i - 1);
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
