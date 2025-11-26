package Linked_Lists;

public class DoubleLL {
    // <=>
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public static void printLL() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data+" <-> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
        return;
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();

        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.addFirst(5);
        dll.addFirst(6);
        dll.addFirst(7);
        dll.addFirst(8);

        printLL();
    }
}
