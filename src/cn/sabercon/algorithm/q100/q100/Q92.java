package cn.sabercon.algorithm.q100.q100;

/**
 * Reverse Linked List II
 * <p>
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 * @author ywk
 * @date 2020-03-19
 */
public class Q92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        int count = 1;
        ListNode begin = sentry;
        ListNode end = head;
        while (count < m) {
            begin = begin.next;
            end = end.next;
            count++;
        }
        while (count < n) {
            ListNode temp = begin.next;
            begin.next = end.next;
            end.next = end.next.next;
            begin.next.next = temp;
            count++;

        }
        return sentry.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
