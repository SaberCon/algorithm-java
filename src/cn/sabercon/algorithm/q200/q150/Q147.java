package cn.sabercon.algorithm.q200.q150;

/**
 * Insertion Sort List
 *
 * Sort a linked list using insertion sort.
 *
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 *  
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 * @author ywk
 * @date 2020-03-25
 */
public class Q147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = head;
        while (current.next != null) {
            if (current.val <= current.next.val) {
                current = current.next;
            } else {
                ListNode node = current.next;
                current.next = current.next.next;
                ListNode index = dummyHead;
                while (index.next.val <= node.val) {
                    index = index.next;
                }
                node.next = index.next;
                index.next = node;
            }
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
