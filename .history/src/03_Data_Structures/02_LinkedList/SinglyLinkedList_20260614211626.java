
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
            Node temp = head;
            Node tail = head;
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
    }

    public Node get(int value) {
        if (value < 0 || value >= size) {
            System.out.println("invalid index");
            return null;
        }
        Node temp = head;
        for (int i = 0; i < value; i++) {
            temp = temp.next;
        }
        System.out.println(temp);
        return temp;
    }

    public boolean set(int value, int index) {
        Node temp = get(value);
        if(temp != null){
            temp.data = value;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList(4); // create first node
        linkedList.append(5); // add
        linkedList.append(6); // add
        linkedList.append(7); // add
        linkedList.append(8); // add

        linkedList.removeLast(); // remove-last

        linkedList.prepend(3); // add-first
        linkedList.prepend(2); // add-first
        linkedList.prepend(1); // add-first

        linkedList.removeFirst(); // remove-first

        linkedList.get(1); // get

        linkedList.set(10 , );

        linkedList.printLinkedList(); // print all nodes
    }
}