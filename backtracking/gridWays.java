package backtracking;
public class gridWays { 

    public static void main(String[] args) {
        int n = 3;
        int m = 3;

        System.out.println(gridWays(0, 0, n, m));
    }

    public static int gridWays(int i, int j, int n, int m) {
        //base case
        if(i == n-1 || j == m-1){
            return 1;
        }
        if(i >= n || j >= m){
            return 0;
        }

        //move down
        int downWays = gridWays(i + 1, j , n, m);

        //move right
        int rightWays = gridWays(i, j + 1, n, m);

        return downWays + rightWays;
    }
}