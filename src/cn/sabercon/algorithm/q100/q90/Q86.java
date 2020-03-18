package cn.sabercon.algorithm.q100.q90;

/**
 * Partition List
 * <p>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * @author ywk
 * @date 2020-03-18
 */
public class Q86 {

    public ListNode partition(ListNode head, int x) {
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode begin = sentry;
        ListNode end = sentry;
        while (end.next != null) {
            if (end.next.val < x) {
                if (end == begin) {
                    end = end.next;
                    begin = begin.next;
                } else {
                    ListNode temp = begin.next;
                    begin.next = end.next;
                    end.next = end.next.next;
                    begin.next.next = temp;
                    begin = begin.next;
                }
            } else {
                end = end.next;
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
