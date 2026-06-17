package linked_list;

import java.util.PriorityQueue;

public class mergeKSortedLL {
    class Node{
        int data;
        Node next;
        Node(int data){
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

        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }
    public Node mergeLists(Node heads[]){
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (Node head : heads){
            pq.offer(head);
        }
        Node dummy = new Node(0);
        Node tail = dummy;
        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(current != null){
                tail.next = current;
                tail = tail.next;
            }
            if(current.next != null){
                pq.offer(current.next);
            }
        }
        return dummy.next;
    }
    public void printList(Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        mergeKSortedLL list = new mergeKSortedLL();
        list.addLast(0);
        list.addLast(4);
        list.addLast(5);
        
        mergeKSortedLL list2 = new  mergeKSortedLL();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);

        Node mergedHead = list.mergeLists(new Node[]{list.head, list2.head});
        list.printList(mergedHead);
    }
}
