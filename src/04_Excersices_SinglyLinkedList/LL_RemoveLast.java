public class LL_RemoveLast {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LL_RemoveLast(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0)
            return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public static void main(String[] args) {
        LL_RemoveLast ll = new LL_RemoveLast(1);
        ll.append(2);
        ll.append(3);
        ll.removeLast();
        ll.printAll();

    }

}

// LL:

// Remove Last
// Implement a
// method called
// removeLast that
// removes the
// last node
// from the
// linked list.

// Return type:

// Node (we are returning the Node that is being removed)

// The method should perform the following tasks:

// If the length of the linked list is 0, return null.

// Create two variables that can point to a Node , temp and pre, both initially
// pointing to the head of the linked list.

// Traverse the linked list until temp.next is null, performing the following
// tasks during traversal:

// Update pre to point to the current temp node.

// Update temp to point to the next node in the linked list.

// After traversal, set the tail pointer to pre.

// Set the next attribute of the tail node to null.

// Decrement the length attribute of the list by 1.

// If the length of the linked list becomes 0 after removing the last node, set
// both the head and tail pointers to null.

// Return the

// removed node (pointed to by temp).
