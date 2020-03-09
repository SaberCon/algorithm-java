package cn.sabercon.algorithm.q100.q20;

/**
 * Remove Nth Node From End of List
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <p>
 * Note:
 * Given n will always be valid.
 * <p>
 * Follow up:
 * Could you do this in one pass?
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @author ywk
 * @date 2020-03-09
 */
public class Q19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        getReverseOrderAndRemove(sentry, n);
        return sentry.next;
    }

    private int getReverseOrderAndRemove(ListNode node, int n) {
        if (node.next == null) {
            return 0;
        }
        int order = getReverseOrderAndRemove(node.next, n) + 1;
        if (order == n) {
            node.next = node.next.next;
        }
        return order;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
