package stack;

import java.util.Stack;

public class validParenthesis {
    public static boolean isValidParenthesis(String text){
        Stack<Character> s = new Stack<>();
        for(int i=0 ; i<text.length() ; i++){
            char c = text.charAt(i);
            if( c == ')' || c=='}' || c==']'){
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek() == '(' && c==')') || 
                (s.peek() == '{' && c=='}') ||
                (s.peek() == '[' && c==']')){
                    s.pop();
                }
                else{
                    return false;
                }
            }
            else{
                s.push(c);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isValidParenthesis("(([]))"));
    }
}
