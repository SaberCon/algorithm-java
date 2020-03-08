package cn.sabercon.algorithm.q100.q10;

/**
 * Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @author ywk
 * @date 2020-03-08
 */
public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(l1.val + l2.val);
        ListNode temp = result;
        ListNode empty  = new ListNode(0);
        while (l1.next != null || l2.next != null) {
            l1 = l1.next == null ? empty : l1.next;
            l2 = l2.next == null ? empty : l2.next;
            if (temp.val > 9) {
                temp.val -= 10;
                temp.next = new ListNode(l1.val + l2.val + 1);
            } else {
                temp.next = new ListNode(l1.val + l2.val);
            }
            temp = temp.next;
        }
        if (temp.val > 9) {
            temp.val -= 10;
            temp.next = new ListNode(1);
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
