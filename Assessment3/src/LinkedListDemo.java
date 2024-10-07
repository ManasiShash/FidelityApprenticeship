import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;


    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }


    public void removeAtIndex(int index) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (index < 0) {
            System.out.println("Invalid index.");
            return;
        }

        Node current = head;


        if (index == 0) {
            head = current.next;
            return;
        }


        for (int i = 0; i < index - 1; i++) {
            current = current.next;
            if (current == null) {
                System.out.println("Index out of range.");
                return;
            }
        }


        if (current.next == null) {
            System.out.println("Index out of range.");
            return;
        }


        Node nodeToDelete = current.next;
        current.next = nodeToDelete.next;
        nodeToDelete = null;
    }


    public void display() {
        Node current = head;
        if (current == null) {
            System.out.println("List is empty.");
            return;
        }
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < 4; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int data = scanner.nextInt();
            linkedList.append(data);
        }


        System.out.println("Current Linked List:");
        linkedList.display();


        System.out.print("Enter the index of the element to remove: ");
        int indexToRemove = scanner.nextInt();


        linkedList.removeAtIndex(indexToRemove);


        System.out.println("Linked List after removal:");
        linkedList.display();

        scanner.close();
    }
}
