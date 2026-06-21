package stack;

import java.util.Stack;

public class nextGreaterElement {
    public static int[] calculateGreatFirstElement(int[] arr){
        Stack<Integer> s = new Stack<>();
        int[] result = new int[arr.length];
        for(int i=arr.length-1 ; i>=0 ; i--){
            int current = arr[i];
            while(!s.isEmpty() && current > s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                result[i]=-1;
                s.push(current);
            }
            else{
                result[i] = s.peek();
                s.push(arr[i]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {9,3,5,1,6,7,5,4};
        int[] result = calculateGreatFirstElement(arr);
        for(int ele : result){
            System.out.print(ele+" ");
        }
    }
}
