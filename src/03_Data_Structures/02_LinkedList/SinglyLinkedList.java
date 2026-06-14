
public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node { // Create's structure of node
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public SinglyLinkedList(int value) {
        Node newnNode = new Node(value);
        head = newnNode;
        tail = newnNode;
        size = 1;
    }

    public void printLinkedList() { // Print's all the nodes in the linkedlist
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void append(int value) { // Add's node to the end of the linkedlist
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("empty Linkedlist");
            return;
        }
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        }
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("empty Linkedlist");
            return;
        }
        Node temp = head;

        head = head.next;
        temp.next = null;
        size--;

        if (size == 0) {
            tail = null;
        }
    }

    // Public get method returns the data at the specified index
    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("invalid index");
            return -1;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // Sets the data at the specified index to value
    public boolean set(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println("invalid index");
            return false;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = value;
        return true;
    }

    // Inserts a new node with value at the specified index
    public boolean Insert(int value, int index) {
        if (index < 0 || index > size)
            return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == size) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        return true;

    }

    public boolean Remove(int index) {
        if (index < 0 || index > size)
            return false;
        if (index == 0) {
            removeFirst();
            return true;
        }
        if (index == size) {
            removeLast();
            return true;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
        return true;
    }

    public void ReverseLl() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < size; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList(4); // create first node
        linkedList.append(5); // add
        linkedList.append(6); // add
        linkedList.append(7); // add
        linkedList.append(8); // add

        // linkedList.removeLast(); // remove-last

        linkedList.prepend(3); // add-first
        linkedList.prepend(2); // add-first
        linkedList.prepend(1); // add-first

        // linkedList.removeFirst(); // remove-first

        System.out.println("Value at index 1: " + linkedList.get(1)); // get

        linkedList.set(2, 10); // set index 2 to 10
        linkedList.Insert(99, 2); // insert 99 at index 2

        // linkedList.Remove(4);
        linkedList.ReverseLl();

        System.out.println("Printing list:");
        linkedList.printLinkedList(); // print all nodes
    }
}