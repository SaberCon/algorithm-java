package cn.sabercon.algorithm.q400.q330;

/**
 * Odd Even Linked List
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 * <p>
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 * <p>
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 *
 * @author ywk
 * @date 2020-04-24
 */
public class Q328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddTail = head;
        ListNode evenTail = head.next;
        boolean odd = true;
        while (evenTail.next != null) {
            if (odd) {
                ListNode temp = oddTail.next;
                oddTail.next = evenTail.next;
                evenTail.next = evenTail.next.next;
                oddTail = oddTail.next;
                oddTail.next = temp;
            } else {
                evenTail = evenTail.next;
            }
            odd = !odd;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
