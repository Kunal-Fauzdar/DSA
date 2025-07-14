public class transposematrix {
    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3},
            {4,5,6}
        };
        transpose(arr);
    }
    public static void transpose(int[][] arr){
        int[][] transarr = new int[arr[0].length][arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[0].length;j++){
                transarr[j][i]=arr[i][j];
            }
        }
        printNums(transarr);
    }
    public static void printNums(int[][] nums){
        for(int turns = 0 ; turns < nums.length ; turns++ ){
            for(int j = 0 ; j < nums[0].length;j++){
                System.out.print(nums[turns][j]+" ");
            }
            System.out.println();
            
        }
    }
}
