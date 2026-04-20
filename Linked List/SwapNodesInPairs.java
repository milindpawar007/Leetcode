public class SwapNodesInPairs {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // swap pointers
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // move prev
            prev = first;
        }

        return dummy.next;
    }
}