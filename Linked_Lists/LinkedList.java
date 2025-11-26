package Linked_Lists;

public class LinkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public Node addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            size = 1;
            return head;
        }
        newNode.next = head;
        head = newNode;
        size++;
        return head;
    }

    public Node addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            size = 1;
            return head;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
        return head;
    }

    public Node add(int data, int idx) {
        Node newNode = new Node(data);
        if(idx == 0) {
            addFirst(data);
            return head;
        }
        Node currNode = head;
        int i=0;
        while (i != idx-1) {
            currNode = currNode.next;
        }
        if(currNode.next == null) {
            addLast(data);
            return head;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
        size++;
        return head;
    }

    public void printLL(Node head) {
        Node currNode = head;
        while (currNode.next != null) {
            System.out.print(currNode.data + "->");
        }
        System.out.print("null");
        System.out.println();
    }

    public int removeFirst(Node head) {
        if(size == 0) {
            System.out.println("Liked List is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1) {
            int deletedVal = head.data;
            head = null;
            tail = null;
            size=0;
            return deletedVal;
        }
        int deletedVal = head.data;
        head = head.next;
        size--;
        return deletedVal;
    }

    public int removeLast(Node head) {
        if(size == 0) {
            System.out.println("Liked List is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1) {
            int deletedVal = head.data;
            head = null;
            tail = null;
            size=0;
            return deletedVal;
        }
        Node prev = head;
        for(int i=0; i<=size-2; i++) {
            prev=prev.next;
        }
        int deletedVal = tail.data;
        prev.next = null;
        size--;
        return deletedVal;
    }

    public static int search(Node head, int tar) {
        Node temp = head;
        int idx=0;
        while (temp != null) {
            if(temp.data == tar) {
                return idx;
            }
            idx++;
        }
        return Integer.MIN_VALUE;
    }
    
    public Node findMid(Node head) {
        //slow-fast approach (aka turtle-hare approach)
        //since slow is covering half as compared to fast
        //slow = slow.next; (+1) or turtle = turtle.next
        //fast = fast.next.next; (+2) or hare = hare.next
        //Having said that ,
        //When fast is at the end of LL , slow will be halfway through
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public boolean isPalindrome(Node head) {
        if(head == null || head.next == null) {
            return true;
        }

        Node left = head;
        Node mid = findMid(head);
        Node right = reverse(mid);

        while (left != null && right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public boolean hasCycle(Node head) {
        Node turtle = head;
        Node hare = head;

        while (hare != null && hare.next != null) {
            if(turtle == hare) {
                return true;
            }
            turtle = turtle.next;
            hare = hare.next.next;
        }

        return false;
    }

    public Node hasCycle2(Node head) {
        Node turtle = head;
        Node hare = head;

        while (hare != null && hare.next != null) {
            if(turtle == hare) {
                return turtle;
            }
            turtle = turtle.next;
            hare = hare.next.next;
        }

        return null;
    }

    public Node removeCycle(Node head) {
        if(!hasCycle(head)) {
            return head;
        }
        Node fast = hasCycle2(head);
        Node slow = head;
        Node prev = null;

        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        prev.next = null;

        return head;
    }
    public static void main(String args[]) {
        
    }
}