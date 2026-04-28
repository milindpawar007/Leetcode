/**
 * LeetCode #25 - Reverse Nodes in K-Group
 * Difficulty: Hard
 *
 * Problem:
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list. k is a positive integer and is less than or
 * equal to the length of the linked list. If the number of nodes is not a
 * multiple of k then left-out nodes at the end should remain as they are.
 *
 * Approach: Recursion
 * - Check if at least k nodes remain; if not, return head as-is.
 * - Recursively process the remainder of the list beyond the current k-group.
 * - Reverse the current k-group in-place.
 * - Connect the tail of the reversed group to the result of the recursive call.
 *
 * Time Complexity: O(n) — every node is visited once
 * Space Complexity: O(n/k) — recursion stack depth equals number of k-groups
 *
 * Example:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 */
public class ReverseKGroup {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Reverses nodes of the linked list k at a time.
     *
     * @param head the head of the linked list
     * @param k    number of nodes to reverse at a time
     * @return head of the modified linked list
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        // Step 1: Check if at least k nodes exist from current position.
        // If fewer than k nodes remain, return head unchanged (base case).
        ListNode temp = head;
        int count = 0;
        while (count < k) {
            if (temp == null) {
                return head; // fewer than k nodes left — no reversal needed
            }
            temp = temp.next;
            count++;
        }
        // At this point, `temp` points to the node just after the current k-group

        // Step 2: Recursively reverse the remainder of the list (everything after
        // the current k-group). `newPrev` will be the new head of that reversed tail.
        ListNode newPrev = reverseKGroup(temp, k);

        // Step 3: Reverse the current k-group in-place using iterative reversal.
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        count = 0;

        while (count < k) {
            next = curr.next; // save next node before overwriting pointer
            curr.next = prev; // reverse the current node's pointer
            prev = curr; // move prev forward
            curr = next; // move curr forward
            count++;
        }
        // After the loop:
        // `prev` = new head of the reversed k-group
        // `head` = original head, now the tail of the reversed k-group

        // Step 4: Connect the tail of the reversed k-group to the
        // head of the recursively reversed remainder.
        head.next = newPrev;

        // Step 5: Return the new head of the reversed k-group.
        return prev;
    }

    // -----------------------------------------------------------------------
    // Helper: build a linked list from an array
    // -----------------------------------------------------------------------
    private static ListNode build(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : arr)
            cur = (cur.next = new ListNode(v));
        return dummy.next;
    }

    // Helper: print a linked list
    private static void print(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null)
                sb.append(", ");
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    // -----------------------------------------------------------------------
    // Quick smoke-test
    // -----------------------------------------------------------------------
    public static void main(String[] args) {
        ReverseKGroup sol = new ReverseKGroup();

        // Test 1: k=2 → [2,1,4,3,5]
        print(sol.reverseKGroup(build(new int[] { 1, 2, 3, 4, 5 }), 2));

        // Test 2: k=3 → [3,2,1,4,5]
        print(sol.reverseKGroup(build(new int[] { 1, 2, 3, 4, 5 }), 3));

        // Test 3: k > length → [1,2] (no reversal)
        print(sol.reverseKGroup(build(new int[] { 1, 2 }), 3));

        // Test 4: k=1 → [1,2,3] (no change)
        print(sol.reverseKGroup(build(new int[] { 1, 2, 3 }), 1));
    }
}