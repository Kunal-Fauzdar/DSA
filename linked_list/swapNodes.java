package linked_list;

public class swapNodes {
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head ;
    Node tail ;
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

    public void swapNodes(int x, int y) {
        if(x > size || y > size){
            return;
        }
        Node prev=null;
        Node current=null;
        Node after=null;
        Node itr = head;
        int i = 1;
        if(x==1){
            prev=null;
            current = head;
            after = head.next;
        }
        while(itr != null){
            if(i == x-1){
                prev = itr;
                current = itr.next;
                after = itr.next.next;
            }
            if(i == y-1){
                Node temp = itr.next.next;
                if(prev != null){
                    prev.next = itr.next;
                }
                else{
                    head = itr.next;
                }
                if(itr != current){
                    itr.next.next = after;
                    itr.next = current;
                    current.next = temp;
                }
                else{
                    itr.next.next = current;
                    current.next = temp;
                }
            }
            itr = itr.next;
            i++;
        }
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        swapNodes list = new swapNodes();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.display();
        list.swapNodes(4,5);
        list.display();
    }
}
