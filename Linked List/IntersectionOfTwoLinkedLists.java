import java.util.*;

public class IntersectionOfTwoLinkedLists {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     * ---------------------------------------------------------
     * APPROACH 1: Length Alignment
     * Time: O(m + n)
     * Space: O(1)
     * ---------------------------------------------------------
     */
    public ListNode getIntersectionNode_LengthApproach(ListNode headA, ListNode headB) {

        int lenA = length(headA);
        int lenB = length(headB);

        // Align both lists
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // Move together
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA; // intersection or null
    }

    private int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    /*
     * ---------------------------------------------------------
     * APPROACH 2: Two Pointer Switching (BEST)
     * Time: O(m + n)
     * Space: O(1)
     * ---------------------------------------------------------
     */
    public ListNode getIntersectionNode_TwoPointer(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        // Traverse both lists, switch when reaching end
        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        return p1; // intersection or null
    }
}