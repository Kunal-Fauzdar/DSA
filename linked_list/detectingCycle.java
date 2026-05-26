package linked_list;

public class detectingCycle {
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

    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;
        int i = 0;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            i++;
            if(slow == fast) {
                System.out.println("Cycle detected of length: " + i);
                return true; 
            }

        }
        return false; 
    }

    public void removeCycle(){
        //detection
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cycle = true;
                break;
            }
        }

        //if not a cycle
        if(!cycle){
            return ;
        }

        //removing cycle
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = null;

    }
    public static void main(String[] args) {
        detectingCycle list = new detectingCycle();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.tail.next = list.head.next; // Creates a cycle (5 -> 2)
        System.out.println("Does the linked list have a cycle? " + list.hasCycle());
        list.removeCycle();
        System.out.println("Does the linked list have a cycle? " + list.hasCycle());
    }
}
