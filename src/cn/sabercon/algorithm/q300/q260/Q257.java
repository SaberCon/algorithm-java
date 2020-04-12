package cn.sabercon.algorithm.q300.q260;

import java.util.*;

/**
 * Binary Tree Paths
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 * @author ywk
 * @date 2020-04-11
 */
public class Q257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        search(ans, root, new StringBuilder());
        return ans;
    }

    private void search(List<String> ans, TreeNode root, StringBuilder builder) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans.add(builder.append(root.val).toString());
        } else {
            builder.append(root.val).append("->");
            search(ans, root.right, new StringBuilder(builder));
            search(ans, root.left, builder);
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
