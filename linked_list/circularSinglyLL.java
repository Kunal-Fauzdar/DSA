package linked_list;

public class circularSinglyLL {
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

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void removeFirst() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
    }

    public void removeLast() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head == tail) {
            head = tail = null;
            return;
        }
        Node current = head;
        while(current.next != tail) {
            current = current.next;
        }
        current.next = head;
        tail = current;
    }

    public void printList() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while(current != head);
        System.out.println();
    }
}
