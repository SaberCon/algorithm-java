package cn.sabercon.algorithm.q200.q150;

/**
 * Sort List
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 * @author ywk
 * @date 2020-03-25
 */
public class Q148 {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        sort(dummyHead, null);
        return dummyHead.next;
    }

    private void sort(ListNode start, ListNode end) {
        if (start.next == end) {
            return;
        }
        ListNode node = start.next;
        ListNode current = node;
        while (current.next != end) {
            if (current.next.val < node.val) {
                ListNode temp = start.next;
                start.next = current.next;
                current.next = current.next.next;
                start.next.next = temp;
            } else {
                current = current.next;
            }
        }
        sort(start, node);
        sort(node, end);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
