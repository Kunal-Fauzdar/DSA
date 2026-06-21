package stack;

import java.util.Stack;

public class stockSpan {
    public static int[] calculateStockSpan(int[] stocks){
        Stack<Integer> s = new Stack<>();
        int[] span = new int[stocks.length];
        span[0] = 0 ;
        s.push(0);
        for(int i=1 ; i<stocks.length ; i++){
            int current = stocks[i];
            while(!s.isEmpty() && current > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
                s.push(i);
            }
            else{
                System.out.println("current "+i+" top "+s.peek());
                span[i] = i-s.peek();
                s.push(i);
            }
        }
        return span;
    }
    public static void main(String[] args) {
        int[] stocks = {80,60,70,60,100,40,50};
        int[] result = calculateStockSpan(stocks);
        for(int e : result){
            System.out.println(e+" ");
        }
    }
}
