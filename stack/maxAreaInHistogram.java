package stack;

import java.util.Stack;

public class maxAreaInHistogram {
    public static int calculateMaxAreaHistogram(int[] hist){
        int max = 0;
        int[] nsl = new int[hist.length];
        int[] nsr = new int[hist.length];
        Stack<Integer> s1 = new Stack<>();
        for(int i=hist.length-1 ; i>=0 ; i--){
            while(!s1.isEmpty() && hist[s1.peek()] >= hist[i]){
                s1.pop();
            }
            if(s1.isEmpty()){
                nsr[i] = hist.length;
            }else{
                nsr[i] = s1.peek();
            }
            s1.push(i);
        }
        Stack<Integer> s2 = new Stack<>();
        for(int i=0 ; i<hist.length ; i++){
            while(!s2.isEmpty() && hist[s2.peek()] >= hist[i]){
                s2.pop();
            }
            if(s2.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s2.peek();
            }
            s2.push(i);
        }
        for(int i=0 ; i<nsr.length ; i++){
            System.out.println(hist[i] * (nsr[i]-nsl[i]-1));
            max = Math.max(max, hist[i] * (nsr[i]-nsl[i]-1));    //height * width(rightSmall-leftSmall-1)
        }
        return max;
    }
    public static void main(String[] args) {
        int[] hist = {1,2,4,5,3,2,1,3};
        System.out.println(calculateMaxAreaHistogram(hist));
    }
}
