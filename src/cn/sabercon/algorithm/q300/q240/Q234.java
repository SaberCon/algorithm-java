package cn.sabercon.algorithm.q300.q240;

/**
 * Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * @author ywk
 * @date 2020-04-10
 */
public class Q234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare.next != null && hare.next.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        return false;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
