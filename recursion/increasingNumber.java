package recursion;

public class increasingNumber {
    public static void main(String[] args) {
        printdec(10);
    }

    public static void printdec(int n){
        if(n==0){
            return;
        }
        printdec(n-1);
        System.out.println(n);
    }
}
