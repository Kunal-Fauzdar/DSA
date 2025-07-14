public class diagonalSum {
    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3,10},
            {4,5,6,11},
            {7,8,9,12},
            {13,14,15,16}
        };
        System.out.println(getDiagonalSum(arr));
    }
    public static int getDiagonalSum(int[][] arr){
        int sum=0;
        for(int i = 0 ; i < arr.length ; i++){
            sum+=arr[i][i];
            if(i!=arr.length-1-i)
                sum+=arr[i][arr.length-1-i];
        }   
        return sum;
    }
}
