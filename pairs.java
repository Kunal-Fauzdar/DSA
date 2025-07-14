public class pairs {
    public static void main(String[] args) {
       int[] arr={2,4,7,8,10};
       printPairs(arr);             //time complexity n(n-1)/2
    }
    public static void printPairs(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j=i ; j<arr.length ;j++) //start from same element because a single element is also subarray
                System.out.print("("+arr[i]+","+arr[j]+")");
            System.out.println();
        }
    }
}
