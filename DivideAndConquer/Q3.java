package DivideAndConquer;

// Given an array of integers. Find the Inversion Count in the array.
// Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
// If the array is already sorted then the inversion count is 0.
// If an array is sorted in the reverse order then the inversion count is the maximum.
// Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
public class Q3 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 0, 1, 3, 5};
        System.out.println("Inversion Count: " + mergeSortAndCount(arr, 0, arr.length - 1));
    }

    public static int mergeSortAndCount(int[] arr , int si , int ei ){
        int inversion = 0;
        if(si>=ei){
            return inversion;
        }
        int mid = si + (ei-si)/2;
        inversion += mergeSortAndCount(arr, si, mid);
        inversion += mergeSortAndCount(arr, mid+1, ei);
        inversion += merge(arr , si, mid, ei);
        return inversion;

    }

    public static int merge(int[] arr , int si , int mid , int ei){
        int i=si;
        int j=mid+1;
        int k=0;
        int inversion=0;
        int[] temp = new int[(ei-si+1)];
        while((i<=mid) && (j<=ei)){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
                inversion += mid-i+1;
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(int p=0; p<temp.length; p++){
            arr[si+p]=temp[p];
        }
        return inversion;
    }
}
