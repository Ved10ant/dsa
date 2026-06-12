
public class LinkedList {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Node nodeFirst = new Node(10);
        Node nodeSecond = new Node(20);
        Node nodeThird = new Node(30);

        nodeFirst.next = nodeSecond;
        nodeSecond.next = nodeThird;

        Node temp = nodeFirst;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
