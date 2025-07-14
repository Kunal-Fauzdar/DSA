public class maxsubarray {
    public static void main(String[] args) {
        int[] arr = {3,-2,5,6,-6,9};
        maxsum(arr);
    }
    public static void maxsum(int[] arr){
        int maxsum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                int sum=0;
                for(int k = i ; k <= j ; k++){
                    sum += arr[k]; 
                }
                if(sum>maxsum){
                    maxsum=sum;
                }
            }    
        }
        System.out.println(maxsum);
    }
}
