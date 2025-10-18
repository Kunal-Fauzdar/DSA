package DivideAndConquer;

public class SortedAndRotatedSearch {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        int result = search(arr, 0 , arr.length - 1, target);
        System.out.println("Element found at index: " + result);
    }



    public static int search(int[] arr, int si, int ei, int target) {
        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        // If middle element is in left sorted half
        if (arr[si] <= arr[mid]) {
            if (target >= arr[si] && target < arr[mid]) {
                return search(arr, si, mid - 1, target);
            } else {
                return search(arr, mid + 1, ei, target);
            }
        }

        // If middle element is in right sorted half
        if (target > arr[mid] && target <= arr[ei]) {
            return search(arr, mid + 1, ei, target);
        }

        return search(arr, si, mid - 1, target);
    }
}
