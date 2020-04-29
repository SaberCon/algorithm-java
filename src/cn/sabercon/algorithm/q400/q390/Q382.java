package cn.sabercon.algorithm.q400.q390;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Linked List Random Node
 *
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 *
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 *
 * Example:
 *
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 *
 * @author ywk
 * @date 2020-04-29
 */
public class Q382 {

    private ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Q382(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int n = 2;
        int random = head.val;
        ListNode current = head.next;
        while (current != null) {
            if (ThreadLocalRandom.current().nextInt(n) == 0) {
                random = current.val;
            }
            current = current.next;
            n++;
        }
        return random;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
