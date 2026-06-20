public class LinkedList {

    private Node head;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
    }

    public Node getHead() {
        return head;
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
    }
    
    public int binaryToDecimal(){
        int decimalValue = 0;
        
        Node current = head;
        
        while(current != null){
            decimalValue = decimalValue * 2 + current.value;
            current = current.next;
        }
        return decimalValue;
        
    }
    public static void main(String[] args) {
        LinkedList binaryList = new LinkedList(1);
        binaryList.append(0);
        binaryList.append(1);
        binaryList.append(1);

        System.out.print("Binary Linked List: ");
        binaryList.printList();

        int decimalValue = binaryList.binaryToDecimal();
        System.out.println("Decimal Value: " + decimalValue);
    }

}


