package recursion;

public class friendsPairingProblem {
    public static void main(String[] args) {
        System.out.println(friendsPairing(4));
    }
    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        //every one can pair with n-1 people
        return friendsPairing(n - 1) + (n - 1) * friendsPairing(n - 2); //single + pair
    }
}
