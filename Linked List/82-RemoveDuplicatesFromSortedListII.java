import java.util.*;

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

    /*
     * ---------------------------------------------------------
     * APPROACH 1: Remove ALL duplicates (LeetCode 82)
     * Keep only elements that appear once
     * ---------------------------------------------------------
     * Example:
     * Input: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
     * Output: 1 -> 2 -> 5
     *
     * Time: O(n)
     * Space: O(1)
     * ---------------------------------------------------------
     */
    public ListNode deleteDuplicates_RemoveAll(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {

            // detect duplicate block
            if (current.next != null && current.val == current.next.val) {

                // skip all duplicates
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }

                // remove entire block
                prev.next = current.next;

            } else {
                // move prev only when node is unique
                prev = prev.next;
            }

            current = current.next;
        }

        return dummy.next;
    }

    /*
     * ---------------------------------------------------------
     * APPROACH 2: Keep ONE copy (LeetCode 83)
     * Remove duplicates but keep one occurrence
     * ---------------------------------------------------------
     * Example:
     * Input: 1 -> 1 -> 2 -> 3 -> 3
     * Output: 1 -> 2 -> 3
     *
     * Time: O(n)
     * Space: O(1)
     * ---------------------------------------------------------
     */
    public ListNode deleteDuplicates_KeepOne(ListNode head) {

        ListNode current = head;

        while (current != null && current.next != null) {

            if (current.val == current.next.val) {
                // skip duplicate
                current.next = current.next.next;
            } else {
                // move forward
                current = current.next;
            }
        }

        return head;
    }

    /*
     * ---------------------------------------------------------
     * OPTIONAL APPROACH: Using LinkedHashMap (not preferred)
     * ---------------------------------------------------------
     * Time: O(n)
     * Space: O(n)
     * Preserves order but uses extra memory
     * ---------------------------------------------------------
     */
    public ListNode deleteDuplicates_UsingMap(ListNode head) {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        ListNode temp = head;

        // count frequency
        while (temp != null) {
            map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }

        // build result list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                curr.next = new ListNode(entry.getKey());
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}