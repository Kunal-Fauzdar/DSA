package recursion;

public class decreasingNumber {
    public static void main(String[] args) {
        printdec(10);
    }

    public static void printdec(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printdec(n-1);
    }
}
