package stack;

public class stackUsingLinkedList {
    class Stack{
        class Node{
            int data;
            Node next;
            Node(int data){
                this.data = data;
                this.next = null;
            }
        }
        Node head;
        int size;

        boolean isEmpty(){
            return head == null;
        }
        void push(int data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            size++;
        }
        int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int topData = head.data;
            head = head.next;
            size--;
            return topData;
        }
    }
    public static void main(String[] args) {
        stackUsingLinkedList stack = new stackUsingLinkedList();
        Stack s = stack.new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
