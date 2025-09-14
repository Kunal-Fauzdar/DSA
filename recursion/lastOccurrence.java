package recursion;

public class lastOccurrence {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,2,4,5,6};
        System.out.println(lastOcc(arr,4,0));
    }

    public static int lastOcc(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }
        int isFound = lastOcc(arr, target, index + 1);
        if(isFound == -1 && arr[index] == target) {
            return index;
        }
        return isFound;
    }
}
