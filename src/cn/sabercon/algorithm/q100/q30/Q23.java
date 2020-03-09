package cn.sabercon.algorithm.q100.q30;

import java.util.ArrayList;

/**
 * Merge k Sorted Lists
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
public class Q23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ArrayList<ListNode> listNodes = new ArrayList<ListNode>();
        for (int i = 0; i < lists.length - 1; i++) {
            if (i % 2 == 0) {
                listNodes.add(mergeTwoLists(lists[i], lists[i + 1]));
            }
        }
        if (lists.length % 2 == 1) {
            listNodes.add(lists[lists.length - 1]);
        }
        return mergeKLists(listNodes.toArray(new ListNode[0]));
    }

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
