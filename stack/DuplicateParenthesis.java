package stack;

import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean isDuplicateParenthesis(String text){
        Stack<Character> s = new Stack<>();
        char c;
        for(int i=0 ; i<text.length() ; i++){
            c = text.charAt(i);
            if(c==')'){
                int count = 0;
                while(s.pop() != '('){
                    count++;
                }
                if(count < 1){
                    return true;
                }
            }
            else{
                s.push(c);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isDuplicateParenthesis("(((a+b)+c))"));
    }
}
