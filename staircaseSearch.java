class staircaseSearch{
    public static void main(String[] args) {
        int[][] arr = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60},
        };
        int key=23;
        search(arr, key);
    }
    public static boolean search(int[][] arr,int key){
        int row=0;
        int col=arr[0].length-1;
        while(row<arr.length && col>=0){
            if(arr[row][col]==key){
                System.out.println("key found at ("+row+","+col+")");
                return true;
                // ("key found at "+row+" "+col);
            }
            if(key>arr[row][col]){
                row++;
            }
            else{
                col--;
            }
        }
        System.out.println("key not found");
        return false;
    }
}