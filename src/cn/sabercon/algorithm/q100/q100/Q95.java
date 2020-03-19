package cn.sabercon.algorithm.q100.q100;

import java.util.ArrayList;
import java.util.List;

/**
 * Unique Binary Search Trees II
 * <p>
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * <p>
 * Example:
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @author ywk
 * @date 2020-03-19
 */
public class Q95 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>(1);
        if (n == 0) {
            return list;
        }
        list.add(null);
        return generate(1, n, list);
    }

    private List<TreeNode> generate(int begin, int end, List<TreeNode> nullList) {
        if (begin > end) {
            return nullList;
        }
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = begin; i <= end; i++) {
            List<TreeNode> lefts = generate(begin, i - 1, nullList);
            List<TreeNode> rights = generate(i + 1, end, nullList);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    nodes.add(node);
                }
            }
        }
        return nodes;
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
