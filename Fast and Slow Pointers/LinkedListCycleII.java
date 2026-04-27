import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 142: Linked List Cycle II
 *
 * Goal:
 * Return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * Key Insight:
 * - Cycle detection must be based on NODE REFERENCE, not node value.
 */
public class LinkedListCycleII {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Approach 1: Using HashSet
     * Time: O(n)
     * Space: O(n)
     */
    public ListNode detectCycleHashSet(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            if (seen.contains(curr)) {
                return curr; // first repeated node = cycle start
            }
            seen.add(curr);
            curr = curr.next;
        }
        return null;
    }

    /**
     * Approach 2: Floyd’s Cycle Detection (Tortoise & Hare)
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode detectCycleFloyd(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next; // move 1 step
            fast = fast.next.next; // move 2 steps

            if (slow == fast) {
                // Step 2: Find cycle start
                ListNode entry = head;

                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }

                return entry;
            }
        }

        return null; // no cycle
    }

    // Optional: helper to create a cycle for testing
    public static void main(String[] args) {
        LinkedListCycleII solution = new LinkedListCycleII();

        // Example:
        // [-1,-7,7,-4,19,6,-9,-5,-2,-5], pos = 6

        ListNode head = new ListNode(-1);
        ListNode n1 = new ListNode(-7);
        ListNode n2 = new ListNode(7);
        ListNode n3 = new ListNode(-4);
        ListNode n4 = new ListNode(19);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(-9); // cycle starts here (index 6)
        ListNode n7 = new ListNode(-5);
        ListNode n8 = new ListNode(-2);
        ListNode n9 = new ListNode(-5);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        // create cycle
        n9.next = n6;

        ListNode result = solution.detectCycleFloyd(head);

        if (result != null) {
            System.out.println("Cycle starts at node with value: " + result.val);
        } else {
            System.out.println("No cycle");
        }
    }
}