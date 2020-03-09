package cn.sabercon.algorithm.q100.q30;

/**
 * Reverse Nodes in k-Group
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
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
public class Q25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        checkAndReverse(sentry, k);
        return sentry.next;
    }

    private void checkAndReverse(ListNode node, int k) {
        ListNode target = node;
        for (int i = 0; i < k; i++) {
            target = target.next;
            if (target == null) {
                return;
            }
        }
        ListNode next = reverse(node, k);
        checkAndReverse(next, k);
    }

    private ListNode reverse(ListNode node, int k) {
        if (k == 1) {
            return node.next;
        }
        if (k == 2) {
            ListNode temp = node.next;
            node.next = node.next.next;
            temp.next = node.next.next;
            node.next.next = temp;
            return temp;
        }
        ListNode target = reverse(node.next, k - 2);
        ListNode temp = node.next;
        node.next = target.next;
        target.next = temp;
        temp = node.next.next;
        node.next.next = target.next.next;
        target.next.next = temp;
        return target.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
