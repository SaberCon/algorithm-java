package cn.sabercon.algorithm.q100.q100;

/**
 * Recover Binary Search Tree
 * <p>
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * <p>
 * Example 1:
 * Input: [1,3,null,null,2]
 * 1
 * /
 * 3
 * \
 * 2
 * Output: [3,1,null,null,2]
 * 3
 * /
 * 1
 * \
 * 2
 * <p>
 * Example 2:
 * Input: [3,1,4,null,null,2]
 * 3
 * / \
 * 1   4
 * /
 * 2
 * Output: [2,1,4,null,null,3]
 * 2
 * / \
 * 1   4
 * /
 * 3
 * <p>
 * Follow up:
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 *
 * @author ywk
 * @date 2020-03-20
 */
public class Q99 {

    public void recoverTree(TreeNode root) {
        TreeNode[] wrong = new TreeNode[2];
        findWrong(root, new TreeNode(Integer.MIN_VALUE), new TreeNode(Integer.MAX_VALUE), wrong);
        int temp = wrong[0].val;
        wrong[0].val = wrong[1].val;
        wrong[1].val = temp;
    }

    private TreeNode[] findWrong(TreeNode node, TreeNode preRoot, TreeNode nextRoot, TreeNode[] wrong) {
        TreeNode[] result = new TreeNode[2];
        TreeNode previous;
        TreeNode next;
        if (node.left == null) {
            previous = preRoot;
            result[0] = node;
        } else {
            TreeNode[] left = findWrong(node.left, preRoot, node, wrong);
            previous = left[1];
            result[0] = left[0];
        }
        if (node.val < previous.val) {
            wrong[1] = node;
        }
        if (node.right == null) {
            next = nextRoot;
            result[1] = node;
        } else {
            TreeNode[] right = findWrong(node.right, node, nextRoot, wrong);
            next = right[0];
            result[1] = right[1];
        }
        if (node.val > next.val) {
            if (wrong[0] == null || wrong[0].val < node.val) {
                wrong[0] = node;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.left.right = new TreeNode(2);
        Q99 q99 = new Q99();
        q99.recoverTree(node);
        System.out.println(node.left.val);
        System.out.println(node.left.right.val);
        System.out.println(node.val);
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
