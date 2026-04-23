/*
LeetCode 206 - Reverse Linked List

Approach 1: Using Stack
- Push all node values into a stack
- Pop values and create a new reversed linked list
- Time: O(n)
- Space: O(n)

Approach 2: Iterative In-Place Reversal
- Reverse pointers one by one
- Time: O(n)
- Space: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.Stack;

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Approach 1: Stack
    public ListNode reverseListUsingStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode reverseCurr = dummy;

        while (!stack.isEmpty()) {
            reverseCurr.next = new ListNode(stack.pop());
            reverseCurr = reverseCurr.next;
        }

        return dummy.next;
    }

    // Approach 2: Optimal Iterative
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next; // store next node
            curr.next = prev; // reverse current link
            prev = curr; // move prev forward
            curr = next; // move curr forward
        }

        return prev;
    }
}