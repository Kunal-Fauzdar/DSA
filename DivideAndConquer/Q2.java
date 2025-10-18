package DivideAndConquer;
//Given an array nums of size n, return the majority element. 
//The majority element is the element that appears more than ⌊n/2⌋ times. 
//You may assume that the majority element always exists in the array.
public class Q2 {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElementBoyerMoore(arr));
        System.out.println(majorityElement(arr));
    }

    private static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private static int majorityElementRec(int[] nums, int lo, int hi) {
        // Base case: only one element
        if (lo == hi) {
            return nums[lo];
        }

        // Recurse on left and right halves
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // If both halves agree on the majority element, return it
        if (left == right) {
            return left;
        }

        // Otherwise, count each element and return the "winner"
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public static int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    public static int majorityElementBoyerMoore(int[] nums) {
    int count = 0;
    Integer candidate = null;

    for (int num : nums) {
        if (count == 0) {
            candidate = num;
        }
        count += (num == candidate) ? 1 : -1;
    }

    return candidate;
}

}
