package cn.sabercon.algorithm.q100.q70;

/**
 * Rotate List
 * <p>
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * <p>
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *
 * @author ywk
 * @date 2020-03-16
 */
public class Q61 {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode pointer1 = sentry;
        ListNode pointer2 = sentry;
        int length = 0;
        while (pointer1.next != null) {
            pointer1 = pointer1.next;
            length++;
        }
        int site = length == 0 ? 0 : k % length;
        if (site == 0) {
            return sentry.next;
        }
        for (int i = 0; i < length - site; i++) {
            pointer2 = pointer2.next;
        }
        ListNode temp = sentry.next;
        sentry.next = pointer2.next;
        pointer2.next = pointer1.next;
        pointer1.next = temp;
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
