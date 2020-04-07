package cn.sabercon.algorithm.q300.q230;

/**
 * Count Complete Tree Nodes
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 *
 * @author ywk
 * @date 2020-04-07
 */
public class Q222 {

    public int countNodes(TreeNode root) {
        TreeNode node = root;
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        if (depth < 2) {
            return depth;
        }
        return findLast(root, 1, depth);
    }

    private int findLast(TreeNode root, int count, int depth) {
        if (depth == 2) {
            if (root.right != null) {
                return (count << 1) + 1;
            }
            if (root.left != null) {
                return count << 1;
            }
            return -1;
        }
        int last = findLast(root.right, (count << 1) + 1, depth - 1);
        if (last == -1) {
            last = findLast(root.left, count << 1, depth - 1);
        }
        return last;
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
