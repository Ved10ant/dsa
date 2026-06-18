import java.util.HashSet;

public class RemoveDuplicate_LL {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public RemoveDuplicate_LL(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
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
        } else {
            System.out.println("Head: " + head.value);
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
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public void removeDuplicates() {
        HashSet<Integer> set = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (set.contains(current.value)) {
                prev.next = current.next;
                length--;
            } else {
                set.add(current.value);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicate_LL ll = new RemoveDuplicate_LL(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.append(2);
        ll.append(6);
        ll.append(7);
        ll.append(3);
        ll.append(8);
        ll.append(9);
        ll.append(50);
        ll.append(10);
        ll.append(20);
        ll.append(30);
        ll.printAll();
        ll.removeDuplicates();
        ll.printAll();
    }
}