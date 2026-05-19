package linked_list;
public class palindromeLL {
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

    public Node middleNode() {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindromeLL(){
        Node midNode = middleNode();
        Node prev = null;
        Node current = midNode;
        Node next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        Node right = prev;
        Node left = head;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }
    public static void main(String[] args) {
        palindromeLL list = new palindromeLL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(1);
        // list.addLast(3);
        System.out.println(list.isPalindromeLL());
    }
}
