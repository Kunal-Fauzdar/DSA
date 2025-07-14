public class maxsubarrayopt {
    public static void main(String[] args) {
        int[] arr = {3,-2,5,6,-6,9};
        maxsum(arr);
    }
    public static void maxsum(int[] arr){
        int maxsum = 0;
        int[] prefix = new int[arr.length];
        prefix[0]=arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i ; j < arr.length ; j++){
                int sum = i == 0 ? prefix[j] : prefix[j]-prefix[i-1]; 
                if(sum>maxsum){
                    maxsum=sum;
                }
            }    
        }
        System.out.println(maxsum);
    }
}
