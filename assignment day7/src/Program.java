import java.util.Scanner;


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// here it is linked list class with various operations
class LinkedList {
    Node head;

    // Method to insertion at the tail (Question 1)
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
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

    // Method to insertion at the head (Question 2)
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to insertion at specific pos (Question 3)
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        int count = 0;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to reverse the linked list(Question 5)
    public void reverseList() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        LinkedList list = new LinkedList();

        //Insertion at tail (Quest1)
        System.out.println("Insert nodes at the tail:");
        System.out.println("Enter the number of elements to insert at the tail:");
        int n = sc.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            list.insertAtEnd(data);
        }
        System.out.println("Linked List after inserting at the tail:");
        list.printList();

        // Insert nodes at the head(Quest 2)
        System.out.println("Insert nodes at the head:");
        System.out.println("Enter the number of elements to insert at the head:");
        int m = sc.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < m; i++) {
            int data = sc.nextInt();
            list.insertAtHead(data);
        }
        System.out.println("Linked List after inserting at the head:");
        list.printList();

        // Insert a node at a specific position(Quest3)
        System.out.println("Insert a node at a specific position:");
        System.out.println("Enter the element to insert:");
        int element = sc.nextInt();
        System.out.println("Enter the position to insert the element:");
        int position = sc.nextInt();

        list.insertAtPosition(element, position);
        System.out.println("Linked List after inserting at position " + position + ":");
        list.printList();

        // Reverse the linked list(Quest 5)
        System.out.println("Reversing the Linked List:");
        list.reverseList();
        System.out.println("Linked List after reversal:");
        list.printList();

        sc.close();
    }
}
