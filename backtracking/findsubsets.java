package backtracking;

public class findsubsets {
    public static void main(String[] args) {
        String arr = "abc";
        findSubsets(arr, 0, "");
    }

    public static void findSubsets(String str, int index, String current) {
        // Base case: if index reaches the length of the array, print the current subset
        if (index == str.length()) {
            if(current.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(  current.trim() );
            }
            return;
        }

        // Include the current element in the subset
        findSubsets(str, index + 1, current + str.charAt(index));

        // Exclude the current element from the subset
        findSubsets(str, index + 1, current);
    }
}
