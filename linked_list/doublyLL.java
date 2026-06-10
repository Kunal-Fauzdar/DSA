package linked_list;

public class doublyLL {
    class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
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
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void add(int index, int data) {
        if(index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        int i = 0;
        while(i<index-1) {
            current = current.next;
            i++;
        }
        newNode.next = current.next;
        if(current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void removeFirst() {
        if(head == null) {
            return;
        }
        if(head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if(head == null) {
            return;
        }
        if(head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void reverse() {
        Node current = head;
        Node temp = null;
        while(current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if(temp != null) {
            head = temp.prev;
        }
    }

    public void printList() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
