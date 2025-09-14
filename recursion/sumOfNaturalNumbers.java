package recursion;

//Time complexity O(n)
//Space complexity O(n) due to function call stack
public class sumOfNaturalNumbers {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }
    public static int sum(int n){
        if(n==1){
            return 1;
        }
        return n + sum(n-1);
    }
}
