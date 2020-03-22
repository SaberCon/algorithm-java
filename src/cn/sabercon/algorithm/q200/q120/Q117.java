package cn.sabercon.algorithm.q200.q120;

/**
 * Populating Next Right Pointers in Each Node II
 * <p>
 * Given a binary tree
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
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node,
 * just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 *  
 * Constraints:
 * <p>
 * The number of nodes in the given tree is less than 6000.
 * -100 <= node.val <= 100
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q117 {

    public Node connect(Node root) {
        Node start = root;
        Node next = root;
        while (start != null) {
            while (next != null) {
                if (next.right != null) {
                    next.right.next = findNext(next.next);
                    if (next.left != null) {
                        next.left.next = next.right;
                    }
                } else if (next.left != null) {
                    next.left.next = findNext(next.next);
                }
                next = next.next;
            }
            start = findNext(start);
            next = start;
        }
        return root;
    }

    private Node findNext(Node node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            node = node.next;
        }
        return null;
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
