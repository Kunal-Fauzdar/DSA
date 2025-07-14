import java.util.*;
public class spiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row col:");
        int row=sc.nextInt();
        int col = sc.nextInt();
        System.out.println();
        int[][] arr = new int[row][col];
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        printSpiral(arr);
        sc.close();
    }
    public static void printSpiral(int[][] arr){
        int startrow = 0;
        int endrow = arr.length-1;
        int startcol = 0;
        int endcol = arr[0].length-1;
        while((startrow<=endrow) && (startcol<=endcol)){
            //printing top row 
            for(int i = startcol ; i <= endcol ; i++){
                System.out.print(arr[startrow][i]+" ");
                
            }
            if(startrow==endrow){
                return;        
            }
            startrow++; 
            for(int i = startrow ; i <= endrow ; i++){
                System.out.print(arr[i][endcol]+" ");
            }
            if(startcol==endcol){
                return;
            }
            endcol--;
            for(int i = endcol ; i >= startcol ; i--){
                System.out.print(arr[endrow][i]+" ");
            }
            endrow--;
            for(int i = endrow ; i >= startrow ; i--){
                System.out.print(arr[i][startcol]+" ");
            }
            startcol++;
        }
    }
}
