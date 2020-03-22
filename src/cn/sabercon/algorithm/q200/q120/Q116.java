package cn.sabercon.algorithm.q200.q120;

/**
 * Populating Next Right Pointers in Each Node
 * <p>
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Follow up:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node,
 * just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the given tree is less than 4096.
 * -1000 <= node.val <= 1000
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q116 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        recursiveConnect(root.left, root.right, null);
        return root;
    }

    private void recursiveConnect(Node left, Node right, Node next) {
        if (left == null) {
            return;
        }
        left.next = right;
        right.next = next;
        recursiveConnect(left.left, left.right, right.left);
        recursiveConnect(right.left, right.right, next == null ? null : next.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
