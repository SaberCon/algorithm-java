package cn.sabercon.algorithm.q100.q30;

/**
 * Swap Nodes in Pairs
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
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
public class Q24 {

    public ListNode swapPairs(ListNode head) {
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        swap(sentry);
        return sentry.next;
    }

    private void swap(ListNode node) {
        if (node.next == null || node.next.next == null) {
            return;
        }
        ListNode temp = node.next;
        node.next = node.next.next;
        temp.next = node.next.next;
        node.next.next = temp;
        swap(temp);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
