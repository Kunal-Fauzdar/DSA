public class reversearray {
    public static void main(String[] args) {
        int[] arr={2,4,45,8,10,80,95};
        reversearr(arr);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void reversearr(int[] arr){  //array is passed by refernce so changes made here will be shown in actual array
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            arr[start]=arr[start]+arr[end];
            arr[end]=arr[start]-arr[end];
            arr[start]=arr[start]-arr[end];
            start++;
            end--;
        }
    }
}
