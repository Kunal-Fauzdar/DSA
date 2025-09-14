package recursion;

//Time complexity O(n)
//Space complexity O(n) due to function call stack
public class factorial {
    public static void main(String[] args) {
        System.out.println(fact(5));
    }
    public static int fact(int n){
        if(n==0){
            return 1;
        }
        return n * fact(n-1);
    }
}
