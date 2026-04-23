/*
LeetCode: Partition List

Given the head of a linked list and a value x,
partition it such that all nodes less than x come before nodes greater than or equal to x.

Two approaches:
1. Using new nodes (extra space)
2. Reusing original nodes (optimal)
*/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class PartitionList {

    /*
     * ================================
     * Approach 1: Create New Nodes
     * ================================
     * Time: O(n)
     * Space: O(n)
     */
    public ListNode partitionWithCopy(ListNode head, int x) {

        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        ListNode current = head;

        while (current != null) {

            if (current.val < x) {
                small.next = new ListNode(current.val);
                small = small.next;
            } else {
                large.next = new ListNode(current.val);
                large = large.next;
            }

            current = current.next;
        }

        small.next = largeDummy.next;

        return smallDummy.next;
    }

    /*
     * ================================
     * Approach 2: Reuse Original Nodes (BEST)
     * ================================
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode partitionOptimal(ListNode head, int x) {

        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        ListNode current = head;

        while (current != null) {

            if (current.val < x) {
                small.next = current;
                small = small.next;
            } else {
                large.next = current;
                large = large.next;
            }

            current = current.next;
        }

        // Important: break old links
        large.next = null;

        // Connect two lists
        small.next = largeDummy.next;

        return smallDummy.next;
    }
}