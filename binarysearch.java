class binarysearch{
    public static void main(String[] args) {
       int[] arr={2,4,7,8,10};
       int key = 12;
        System.out.println(findele(arr,key));
    }
    public static int findele(int[] arr,int key){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = (int)(start+end)/2;
            if(key==arr[mid]){
                return arr[mid];
            }else if(key>arr[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}
