package recursion;

//Time complexity O(n)
//Space complexity O(n) due to function call stack
public class power {
    public static void main(String[] args) {
        System.out.println(power(2, 20));
    }

    public static int power(int base, int exp) {
        if (exp == 0) {
            return 1;
        }
        return base * power(base, exp - 1);
    }
        
}
