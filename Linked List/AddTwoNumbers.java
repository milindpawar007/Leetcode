public class AddTwoNumbers {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node helps avoid edge case for head
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        // Traverse both lists until both are finished
        while (l1 != null || l2 != null) {

            int sum = carry; // start with carry

            // Add l1 value if exists
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add l2 value if exists
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Update carry for next iteration
            carry = sum / 10;

            // Create new node with current digit
            current.next = new ListNode(sum % 10);

            // Move pointer forward
            current = current.next;
        }

        // If carry remains (e.g., 9 + 1 = 10)
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // Return result list (skip dummy node)
        return dummy.next;
    }
}