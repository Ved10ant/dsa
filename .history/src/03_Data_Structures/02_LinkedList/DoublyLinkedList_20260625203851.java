
import java.time.temporal.Temporal;



public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newnNode = new Node(value);
        if (length == 0) {
            head = newnNode;
            tail = newnNode;
        } else {
            tail.next = newnNode;
            newnNode.prev = tail;
            tail = newnNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void removeFirst() {
        if (length == 0) {
            return;
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int value, int index) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newdNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;
        newdNode.prev = before;
        newdNode.next = after;
        before.next = newdNode;
        after.prev = newdNode;
        length++;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= length)
            return false;
        if (index == 0) {
            removeFirst();
            return true;
        }
        if (index == length) {
            removeLast();
            return true;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node after = temp.next;
        Node before = temp.prev;
        temp.next = null;
        temp
        length--;
        return true;
    }

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList(3);
        ll.append(4);
        ll.append(5);
        ll.append(6);
        ll.append(7);
        // ll.removeLast();
        // ll.prepend(2);
        // ll.removeFirst();
        // ll.printList();
        // System.out.println(ll.get(3).value);
        // System.out.println(ll.set(3, 45));
        ll.insert(9, 2);
        ll.printList();
    }
}
