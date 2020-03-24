package cn.sabercon.algorithm.q200.q150;

/**
 * Reorder List
 * <p>
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * @author ywk
 * @date 2020-03-24
 */
public class Q143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        ListNode reverse = tortoise.next;
        while (reverse.next != null) {
            ListNode temp = tortoise.next;
            tortoise.next = reverse.next;
            reverse.next = reverse.next.next;
            tortoise.next.next = temp;
        }
        while (tortoise.next != null) {
            ListNode temp = head.next;
            head.next = tortoise.next;
            tortoise.next = tortoise.next.next;
            head.next.next = temp;
            head = temp;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
