public class Partition_LL {

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

    public Partition_LL(int value) {
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
        if (temp == null) {
            System.out.println("empty");
        } else {
            while (temp != null) {
                System.out.print(temp.value);
                temp = temp.next;
                if (temp != null) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
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

    public void partitionList(int x) {
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        Node prev1 = dummy1;
        Node prev2 = dummy2;

        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }

        prev2.next = null;

        prev1.next = dummy2.next;

        head = dummy1.next;

        tail = (dummy2.next != null) ? prev2 : prev1;
    }

    public static void main(String[] args) {
        Partition_LL partitionList = new Partition_LL(3);
        partitionList.append(5);
        partitionList.append(8);
        partitionList.append(5);
        partitionList.append(10);
        partitionList.append(2);
        partitionList.append(1);

        System.out.println("Before Partition:");
        partitionList.printList();

        partitionList.partitionList(5);

        System.out.println("\nAfter Partition:");
        partitionList.printList();
    }

}

// Partition Linked List (Pivot = x)

// Goal:
// Rearrange the linked list so that all nodes with values less than x come
// before nodes with values greater than or equal to x, while preserving their
// original relative order.

// 1. Create two separate lists:

// * D1 (dummy node for smaller values)
// * D2 (dummy node for larger/equal values)

// 2. Create two tail pointers:

// * prev1 = D1
// * prev2 = D2

// 3. Traverse the original linked list using current.

// 4. For each node:

// * Compare current.value with x.
// * If current.value < x:

// * Add the node to the smaller list.
// * Move prev1 to the newly added node.
// * Else:

// * Add the node to the larger list.
// * Move prev2 to the newly added node.

// 5. After traversal:

// * Terminate the larger list:
// prev2.next = null
// * Connect the smaller list with the larger list:
// prev1.next = D2.next

// 6. Update head:

// * head = D1.next
// * D1 is only a dummy node and is not part of the final answer.

// Key Idea:
// Instead of rearranging nodes inside one list, build two separate lists and
// merge them at the end.

// Pointers:

// * D1 → Dummy head of smaller list.
// * prev1 → Tail of smaller list.
// * D2 → Dummy head of larger/equal list.
// * prev2 → Tail of larger/equal list.
// * current → Traverses the original list.

// Complexity:

// * Time: O(n)
// * Space: O(1)

// Pattern Recognition:
// When a Linked List problem asks to separate nodes based on a condition:

// * value < x
// * even vs odd
// * positive vs negative
// * before vs after pivot

// Think:
// "Create multiple lists, append nodes accordingly, then merge them."
