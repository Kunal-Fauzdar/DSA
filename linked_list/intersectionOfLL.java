package linked_list;

public class intersectionOfLL {
    public class Node {
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

    public Node intersection(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node pointer1 = head1;
        Node pointer2 = head2;

        while (pointer1 != pointer2) {
            pointer1 = (pointer1 == null) ? head2 : pointer1.next;
            pointer2 = (pointer2 == null) ? head1 : pointer2.next;
        }

        return pointer1; // This will be the intersection node or null if there is no intersection
    }

    public static void main(String[] args) {
        intersectionOfLL list = new intersectionOfLL();
        Node head1 = list.new Node(1);
        head1.next = list.new Node(2);
        head1.next.next = list.new Node(3);
        head1.next.next.next = list.new Node(4);

        Node intersection = list.new Node(5);
        head1.next.next.next.next = intersection;
        Node head2 = list.new Node(6);
        head2.next = intersection;
        head2.next.next = list.new Node(7);
        Node result = list.intersection(head1, head2);
        System.out.println(result != null ? result.data : "No intersection");
    }
}
