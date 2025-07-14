public class maxsubarrayme {
    public static int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int sum = nums[0];
        System.out.println(sum);
        for(int i = 1 ; i < nums.length ; i++){
            int previous = sum;
            int current = sum + nums[i];
            System.out.println("current"+current);
            if(previous<0 && current<0){
                if(nums[i]>previous){
                    sum = nums[i];
                }
            }
            else{
                if(current>0){
                    if(current>nums[i]){
                        sum = current;
                    }
                    else{
                        if(nums[i]>0){
                            sum=nums[i];
                        }
                        else{
                            sum=0;
                        }
                    }
                    
                }
                else{
                    if(nums[i]>0){
                        sum=nums[i];
                    }else{
                        sum=0;
                    }
                    
                }
                
            }
            if(sum>maxsum){
                maxsum=sum;
            }
            System.out.println("sum : "+sum);
            System.out.println("maxsum"+maxsum);
        }
        return maxsum;
    }
    public static void main(String[] args) {
        int[] arr={-2,3,1,3};
        System.out.println(maxSubArray(arr));
    }
}
