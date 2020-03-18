package cn.sabercon.algorithm.q100.q90;

/**
 * Remove Duplicates from Sorted List II
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 * <p>
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * <p>
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 * @author ywk
 * @date 2020-03-18
 */
public class Q82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode begin = sentry;
        ListNode end = head.next;
        int num = head.val;
        boolean delete = false;
        while (end != null) {
            if (end.val != num) {
                if (delete) {
                    begin.next = end;
                    num = end.val;
                    delete = false;
                } else {
                    num = end.val;
                    begin = begin.next;
                }
            } else {
                delete = true;
            }
            end = end.next;
        }
        if (delete) {
            begin.next = end;
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
