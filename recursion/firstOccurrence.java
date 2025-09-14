package recursion;

//Time complexity O(n)
//Space complexity O(n) due to function call stack
public class firstOccurrence {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,2,4,5,6};
        System.out.println(firstOcc(arr,4,0));
    }

    public static int firstOcc(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }
        if(arr[index] == target) {
            return index;
        }
        return firstOcc(arr, target, index + 1);
    }
}
