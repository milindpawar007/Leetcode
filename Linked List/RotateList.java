public class RotateList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {

        // Edge cases: empty list, single node, or no rotation needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length and tail
        int len = 1;
        ListNode tail = head;

        // IMPORTANT: stop at last node (tail), not null
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        // Step 2: Normalize k (avoid unnecessary rotations)
        k = k % len;
        if (k == 0) {
            return head;
        }

        // Step 3: Make the list circular
        tail.next = head;

        // Step 4: Find new tail
        // new tail is at position (len - k - 1)
        ListNode newTail = head;
        for (int i = 0; i < len - k - 1; i++) {
            newTail = newTail.next;
        }

        // Step 5: New head is next of newTail
        ListNode newHead = newTail.next;

        // Step 6: Break the circle
        newTail.next = null;

        return newHead;
    }
}