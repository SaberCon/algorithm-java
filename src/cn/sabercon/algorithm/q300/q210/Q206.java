package cn.sabercon.algorithm.q300.q210;

/**
 * Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author ywk
 * @date 2020-04-01
 */
public class Q206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = reverse(head)[0];
        return dummyHead.next;
    }

    private ListNode[] reverse(ListNode head) {
        if (head.next == null) {
            return new ListNode[]{head, head};
        }
        ListNode[] nodes = reverse(head.next);
        nodes[1].next = head;
        head.next = null;
        return new ListNode[]{nodes[0], head};
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
