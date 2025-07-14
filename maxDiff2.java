
//Here trailing zeroes are not allowed 
//for ex :- for no. 1105 i cannot do 0005 first number should be lowest(other than zero which is 1)
public class maxDiff2 {
    public static int maxDiff(int num) {
        int maxNum = num;
        int minNum = num;
        int temp=num;
        int max=0;
        int min=0;
        int count=0;
        int remainder = 0;      
        while(num>0){
            remainder = num%10;
            num = (int)(num / 10);
            if(remainder!=9){
                max=remainder;
            }
            if((remainder!=0) && (remainder!=1)){
                min=remainder;
            }
        }  
        while(temp>0){
            int remainder2 = temp%10;
            if(remainder2==max){
                maxNum = maxNum - (int)(remainder2*(Math.pow(10,count)));
                maxNum = maxNum + (int)(9*(Math.pow(10,count)));
            }
            if(remainder2==min){
                if(min == remainder){
                    minNum = minNum - (int)(remainder2*(Math.pow(10,count)));
                    minNum = minNum + (int)(1*(Math.pow(10,count)));
                }
                else{
                    minNum = minNum - (int)(remainder2*(Math.pow(10,count)));
                }
            }
            temp = (int)(temp / 10);
            count ++ ;
        }
        System.out.println(maxNum+" "+minNum);
        return maxNum-minNum;
    }
    public static void main(String[] args) {
        int num = 555 ;
        System.out.println(maxDiff(num));
    }
}
