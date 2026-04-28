class MyLinkedList {

    // Node definition (each element in list)
    private class Node {
        int val;
        Node next;

        Node(int data) {
            this.val = data;
            this.next = null;
        }
    }

    Node head; // first node
    Node tail; // last node (for O(1) add at tail)
    int count; // size of list

    // Initialize empty list
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    // Get value at index
    public int get(int index) {
        if (index < 0 || index >= count) {
            return -1; // invalid index
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next; // move to index
        }

        return temp.val;
    }

    // Add node at beginning
    public void addAtHead(int val) {
        Node node = new Node(val);

        if (count == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }

        count++;
    }

    // Add node at end
    public void addAtTail(int val) {
        Node node = new Node(val);

        if (count == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        count++;
    }

    // Add node at given index
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > count) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == count) {
            addAtTail(val);
            return;
        }

        Node temp = head;
        Node node = new Node(val);

        // move to (index - 1)
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        // insert node
        node.next = temp.next;
        temp.next = node;
        count++;
    }

    // Delete node at given index
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= count) {
            return;
        }

        // delete head
        if (index == 0) {
            head = head.next;
            count--;

            if (count == 0) {
                tail = null;
            }
            return;
        }

        Node temp = head;

        // move to (index - 1)
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        // if deleting last node, update tail
        if (temp.next == tail) {
            tail = temp;
        }

        // skip the node
        temp.next = temp.next.next;
        count--;
    }
}