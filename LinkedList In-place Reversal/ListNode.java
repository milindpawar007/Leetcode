
import java.util.Stack;

public class ListNode {
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

class Solution {
    public ListNode reverseList(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }

        ListNode reverseList = new ListNode(0);
        ListNode revcurr = reverseList;

        while (!stack.isEmpty()) {
            revcurr.next = new ListNode(stack.pop());
            revcurr = revcurr.next;
        }

        return reverseList.next;
    }
}