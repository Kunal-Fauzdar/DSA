package linked_list;

public class Intro {
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
        } else {
            newNode.next = head;
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
            tail = newNode;
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

    public void add(int index, int data) {
        if(index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        int i = 0;
        while(i<index-1 ) {
            current = current.next;
            i++;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public int removeFirst() {
        if(size == 0) {
            System.out.println("List is empty");
            return -1; // or throw an exception
        }
        if(size == 1) {
            int data = head.data;
            head = tail = null;
            size=0;
            return data;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("List is empty");
            return -1; // or throw an exception
        }
        if(size == 1) {
            int data = head.data;
            head = tail = null;
            size=0;
            return data;
        }
        Node current = head;
        while(current.next != tail) {
            current = current.next;
        }
        int data = tail.data;
        tail = current;
        tail.next = null;
        size--;
        return data;
    }

    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null ){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int recursiveSearch(Node head , int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }

        int idx = recursiveSearch(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
    }

    public void reverseList(){
        if(size == 0){
            return ;
        }
        Node prev = null;
        Node current = tail = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int n){
        if(size == 0){
            System.out.println("List is empty");
            return;
        }
        if(n == size){
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        for(int i=1 ; i<size-n ; i++){
            current = current.next;
        }
        current.next = current.next.next;
    }

    public static void main(String[] args) {
        Intro list = new Intro();
        list.addFirst(20);
        list.addFirst(10);
        list.addLast(40);
        list.add(2,30);
        list.printList();
        // System.out.println("Size: " + list.size);
        // System.out.println("Removed First: " + list.removeFirst());
        // System.out.println("Removed Last: " + list.removeLast());
        // list.printList();
        System.out.println("Size: " + list.size);
        System.out.println("Key found at index: " + list.itrSearch(30));

        System.out.println("Key found at index (recursive): " + list.recursiveSearch(list.head, 30));

        list.deleteNthFromEnd(3);
        System.out.println("After deleting nth node from end:");
        list.printList();

        
        list.reverseList();
        list.printList();
    }
}
