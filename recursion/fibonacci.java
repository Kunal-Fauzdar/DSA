package recursion;

//Time complexity O(2n) with memoization
//Space complexity O(2n) due to function call stack and memo array
public class fibonacci {
    public static void main(String[] args) {
        int[] memo = new int[100];
        System.out.println(fib(23,memo));
    }
    public static int fib(int n , int[] memo){ 
        if(n==0 || n==1){
            return n;
        }
        if(memo[n] != 0){
            return memo[n];
        }
        if(memo[n] == 0){
            memo[n] = fib(n-1,memo) + fib(n-2,memo);
        }
        return memo[n];
    }
}
