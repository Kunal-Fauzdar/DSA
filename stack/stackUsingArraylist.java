package stack;

import java.util.ArrayList;

public class stackUsingArraylist {
    class Stack{
        ArrayList<Integer> arr = new ArrayList<>();
        boolean isEmpty(){
            return arr.size() == 0;
        }
        void push(int data){
            arr.add(data);
        }
        int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return arr.remove(arr.size() - 1);
        }
    }
    public static void main(String[] args) {
        stackUsingArraylist stack = new stackUsingArraylist();
        Stack s = stack.new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
