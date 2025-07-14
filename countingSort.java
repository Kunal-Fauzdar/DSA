public class countingSort {
    public static void main(String[] args) {
        int[] arr = {4,2,1,5,3,2,4,1};
        countingSortMethod(arr);
    }
    public static void countingSortMethod(int[] arr){
        int largest = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            largest = Math.max(largest,arr[i]);
        }
        int[] count=new int[largest+1];
        for(int i = 0 ; i < arr.length ; i++){
            count[arr[i]]++;
        }
        int j = 0;
        for(int i = 0 ; i < count.length ; i++){
            while(count[i]>0){
                arr[j]= i;
                j++;
                count[i]--;
            }
        }
        printNums(arr);
    }
    public static void printNums(int[] nums){
        for(int turns = 0 ; turns < nums.length ; turns++ ){
            System.out.print(nums[turns]+" ");
        }
    }
}
