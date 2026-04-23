class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;

        // Find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Skip middle for odd length
        if (fast != null) {
            slow = slow.next;
        }

        // Reverse second half
        slow = reverseList(slow);

        ListNode firstHalf = head;

        // Compare halves
        while (slow != null) {
            if (slow.val != firstHalf.val) {
                return false;
            }
            slow = slow.next;
            firstHalf = firstHalf.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}