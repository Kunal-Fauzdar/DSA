package DivideAndConquer;
//Apply Mergesort to sort an array of Strings.(Assume that all the characters in all the Strings are in lowercase).
public class Q1 {
    public static void main(String[] args) {
        String[] arr = {"banana", "apple", "orange", "kiwi"};
        mergeSort(arr, 0, arr.length - 1);
        for (String s : arr) {
            System.out.println(s);
        }
    }

    public static void mergeSort(String[] arr, int si, int ei) {
        if(si >= ei){
            return;
        }

        int mid = si + (ei-si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(String[] arr, int si, int mid, int ei) {
        String[] temp = new String[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, si, temp.length);
    }
}
