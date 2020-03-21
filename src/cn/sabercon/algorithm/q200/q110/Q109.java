package cn.sabercon.algorithm.q200.q110;

/**
 * Convert Sorted List to Binary Search Tree
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
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
public class Q109 {

    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode listNode = head;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return buildBST(head, length);
    }

    private TreeNode buildBST(ListNode head, int length) {
        if (length <= 0) {
            return null;
        }
        int middle = length / 2;
        ListNode listNode = head;
        for (int i = 0; i < middle; i++) {
            listNode = listNode.next;
        }
        TreeNode treeNode = new TreeNode(listNode.val);
        treeNode.left = buildBST(head, length % 2 == 0 ? length - middle : length - middle - 1);
        treeNode.right = buildBST(listNode.next, length - middle - 1);
        return treeNode;
    }

    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
