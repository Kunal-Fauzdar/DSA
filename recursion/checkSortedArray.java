package recursion;

//Time complexity O(n)
//Space complexity O(n) due to function call stack
public class checkSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(checkSorted(arr,0));
    }

    public static boolean checkSorted(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        if(arr[index] > arr[index + 1]) {
            return false;
        }
        return checkSorted(arr, index + 1);
    }
}
