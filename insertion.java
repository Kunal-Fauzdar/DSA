import java.util.Arrays;
public class insertion {
    public static void main(String[] args) {
        int[] nums={3,1,2,6,5,8,11};
        // insertionSort(nums);
        //Arrays.sort(nums,si,ei)
        //Below both will work only on Integer object
        //Arrays.sort(nums,Collections.reverseOrder())
        //Arrays.sort(nums,si,ei,Collections.reverseOrder())
        Arrays.sort(nums);
        printNums(nums);
    }
    public static void insertionSort(int[] nums){
        int n = nums.length;
        for(int i = 1 ; i < n-1 ; i++){
            int current = nums[i];
            int prev=i-1;
            while(prev>=0 && nums[prev]>current){
                nums[prev+1]=nums[prev];
                prev--;
                
            }
            nums[prev+1]=current;
        }
        printNums(nums);
    }
    public static void printNums(int[] nums){
        for(int turns = 0 ; turns < nums.length ; turns++ ){
            System.out.print(nums[turns]+" ");
        }
    }
}
