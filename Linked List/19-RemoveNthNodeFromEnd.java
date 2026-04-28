class Solution {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 1: create dummy node and connect to head
        ListNode temp = new ListNode(0);
        temp.next = head;

        // Step 2: initialize pointers
        ListNode fast = temp;
        ListNode slow = temp;

        // Step 3: move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 4: move both until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 5: delete target node
        slow.next = slow.next.next;

        // Step 6: return new head
        return temp.next;
    }
}