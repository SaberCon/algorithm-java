package cn.sabercon.algorithm.q100.q90;

/**
 * Remove Duplicates from Sorted List
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 * <p>
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * @author ywk
 * @date 2020-03-18
 */
public class Q83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode begin = head;
        ListNode end = head.next;
        while (end != null) {
            if (begin.val == end.val) {
                end = end.next;
                begin.next = end;
            } else {
                end = end.next;
                begin = begin.next;
            }
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
