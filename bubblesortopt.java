public class bubblesortopt {
    public static void main(String[] args) {
        int[] nums = {5,1,4,2,8,9,10};
        bubbleSort(nums);
        printNums(nums);
    }
    public static void bubbleSort(int[] nums){
        int swap=0;
        for(int turns = 0 ; turns < nums.length ; turns++ ){
            for(int j = turns ; j < nums.length-turns-1 ; j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
            if(swap==0){
                break;
            }
        }
    }
    public static void printNums(int[] nums){
        for(int turns = 0 ; turns < nums.length ; turns++ ){
            System.out.print(nums[turns]+" ");
        }
    }
}
