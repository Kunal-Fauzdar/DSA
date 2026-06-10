package linked_list;
public class mergeSortUsingLL {
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
    private Node middle(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private Node merge(Node head1 , Node head2){
        Node mergell = new Node(-1);
        Node temp = mergell;
        while((head1 != null) && (head2 != null)){
            if(head1.data > head2.data){
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            } else {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergell.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node mid = middle(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node leftHead = head;
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);
        return merge(leftHead, rightHead);
    }
    public static void main(String[] args) {
        mergeSortUsingLL ll = new mergeSortUsingLL();
        ll.addLast(5);
        ll.addLast(4);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();
    }
}
