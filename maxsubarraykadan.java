public class maxsubarraykadan {
    public static void main(String[] args) {
        int[] arr = {3,-2,5,6,-6,9};
        maxsum(arr);
    }
    public static void maxsum(int[] arr){
        int maxsum = arr[0];
        int sum=arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            sum = sum + arr[i];
            System.out.println(sum);
            if(sum<0){
                sum=0;
            }
            if(sum>maxsum){
                maxsum=sum;
            }
        }
        System.out.println(maxsum);
    }
}
