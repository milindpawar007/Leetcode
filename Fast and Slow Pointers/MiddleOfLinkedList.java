/*
LeetCode 876 - Middle of the Linked List

Approach:
- Use fast and slow pointers
- slow moves 1 step, fast moves 2 steps
- When fast reaches end, slow will be at middle

Note:
- For even length → returns SECOND middle (as per problem requirement)

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class MiddleOfLinkedList {

    // LeetCode expected solution (second middle)
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Optional: First middle (if interviewer asks)

}