package cn.sabercon.algorithm.q200.q200;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Right Side View
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * @author ywk
 * @date 2020-03-30
 */
public class Q199 {

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        depthFirstSearch(ans, root, 1);
        return ans;
    }

    private void depthFirstSearch(List<Integer> ans, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > ans.size()) {
            ans.add(root.val);
        }
        depthFirstSearch(ans, root.right, depth + 1);
        depthFirstSearch(ans, root.left, depth + 1);
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
