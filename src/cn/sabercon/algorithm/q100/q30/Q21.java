package cn.sabercon.algorithm.q100.q30;

/**
 * Merge Two Sorted Lists
 * <p>
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
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
public class Q21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(0);
        sentry.next = l1;
        l1 = sentry;
        while (l2 != null) {
            if (l1.next == null) {
                l1.next = l2;
                break;
            }
            if (l1.next.val > l2.val) {
                ListNode temp = l1.next;
                l1.next = l2;
                l2 = l2.next;
                l1 = l1.next;
                l1.next = temp;
            } else {
                l1 = l1.next;
            }
        }
        return sentry.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
