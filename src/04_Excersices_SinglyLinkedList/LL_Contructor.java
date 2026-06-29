public class LL_Contructor {

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

    public LL_Contructor(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    // +===================================================+
    // | WRITE YOUR CODE HERE |
    // | Description: |
    // | - Constructor for the LinkedList class. |
    // | - Initializes the linked list with a single node. |
    // | |
    // | Parameters: |
    // | - value: The integer value of the first node in |
    // | the newly created linked list. |
    // | |
    // | Behavior: |
    // | - A new Node is created with the given value. |
    // | - This node is set as both the head and tail of |
    // | the list, indicating it is the only node in the |
    // | list at creation. |
    // | - The length of the list is initialized to 1. |
    // +===================================================+

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

    public static void main(String[] args) {
        // LL_Contructor list = new LL_Contructor(5);
    }

}

// LL: Constructor
// Create a constructor for a LinkedList class that initializes a new linked
// list with a single node.

// Instructions:

// Understand the Node Structure:

// Before writing the constructor, ensure you're familiar with the Node class,
// which is a nested class within the LinkedList class. Each Node should hold an
// integer value and a reference to the next node (Node next). For the initial
// node, next will be null.

// Constructor Signature:

// Your constructor should be public and named LinkedList. It will accept a
// single integer argument, value, which represents the data to store in the
// list's first node.

// Create the First Node:

// Inside the constructor, use the passed value to create a new instance of the
// Node class. This instance will be the first and only node in your linked list
// upon creation.

// Initialize Head and Tail:

// Assign the newly created node to both the head and tail of the linked list.
// This is because, initially, the list contains only one node, making it both
// the beginning and end of the list.

// Set the List Length:

// Initialize the length of the linked list to 1, reflecting that the list
// currently contains a single node.

// Deliverable:

// Implement the LinkedList constructor following the above guidelines. This
// constructor will lay the foundation for further methods you might implement
// in the LinkedList class, such as adding or removing nodes, searching for
// values, etc.