package stack;

import java.util.Stack;

public class reverseString {
    static void reverseTheString(String text){
        Stack<Character> s = new Stack<>();
        for(int i = 0 ; i < text.length() ; i++){
            s.push(text.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()){
            result.append(s.pop());
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        String text = "kunal";
        reverseTheString(text);
    }
}
