package linked_list;

public class DeleteMNnodes {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void deleteMNnodes(int M, int N) {

        // If M is 0, delete entire list
        if (M == 0) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        Node current = head;

        while (current != null) {

            // Move to the M-th node
            for (int i = 1; i < M && current != null; i++) {
                current = current.next;
            }

            // If end of list is reached
            if (current == null) {
                break;
            }

            // Start from node after M-th node
            Node temp = current.next;

            // Skip N nodes (delete them)
            for (int i = 0; i < N && temp != null; i++) {
                temp = temp.next;
            }

            // Link M-th node to node after deleted nodes
            current.next = temp;

            // Continue from next valid node
            current = temp;
        }
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        DeleteMNnodes list = new DeleteMNnodes();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);

        System.out.print("Original List: ");
        list.printList();

        int M = 2;
        int N = 3;

        list.deleteMNnodes(M, N);

        System.out.print("After Deleting: ");
        list.printList();
    }
}