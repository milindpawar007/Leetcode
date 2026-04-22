import java.util.HashMap;
import java.util.Map;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    // -------------------------------
    // Approach 1: HashMap
    // -------------------------------
    public Node copyRandomList_HashMap(Node head) {
        if (head == null)
            return null;

        Map<Node, Node> map = new HashMap<>();
        Node current = head;

        // Step 1: create copy nodes
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;

        // Step 2: connect next and random
        while (current != null) {
            Node copy = map.get(current);
            copy.next = map.get(current.next);
            copy.random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }

    // -------------------------------
    // Approach 2: Interleaving (O(1) space)
    // -------------------------------
    public Node copyRandomList_Interleaving(Node head) {
        if (head == null)
            return null;

        Node current = head;

        // Step 1: insert copied nodes
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: assign random pointers
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: separate lists
        current = head;
        Node copyHead = head.next;

        while (current != null) {
            Node copy = current.next;
            current.next = copy.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            current = current.next;
        }

        return copyHead;
    }
}