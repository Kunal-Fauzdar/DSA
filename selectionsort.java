public class selectionsort {
    public static void main(String[] args) {
        int[] nums={1,5,2,6,2,10};
        selectionSort(nums);
    }
    public static void selectionSort(int[] nums){
        int n = nums.length;
        for(int i = 0 ; i < n-2 ; i++){
            int minPos=i;
            for(int j = i+1 ; j < n-1 ; j++){
                if(nums[j]<nums[minPos]){
                    minPos=j;
                }
            }
            if(minPos!=i){
                //swap
                int temp = nums[i];
                nums[i]=nums[minPos];
                nums[minPos]=temp;
            }
        }
        printNums(nums);
    }

    public static void printNums(int[] nums){
        for(int turns = 0 ; turns < nums.length ; turns++ ){
            System.out.print(nums[turns]+" ");
        }
    }
}
