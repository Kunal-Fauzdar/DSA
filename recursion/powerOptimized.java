package recursion;

//Time complexity O(log n)
//Space complexity O(log n) due to function call stack
public class powerOptimized {
    public static void main(String[] args) {
        System.out.println(powerOpt(2, 20));
    }

    public static int powerOpt(int base, int exp) {
        if (exp == 0) {
            return 1;
        }
        int halfPower = powerOpt(base, exp / 2);
        int halfPowerSq = halfPower * halfPower;
        if (exp % 2 != 0) {
            halfPowerSq = base * halfPowerSq;
        }
        return halfPowerSq;
    }
}
