package backtracking;

public class findPermutations {
    public static void main(String[] args) {
        String str = "abc";
        findPermutations(str, "");
    }
    public static void findPermutations(String str, String ans) {
        // Base case: if the input string is empty, print the current permutation
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Iterate through the string and generate permutations
        for (int i = 0; i < str.length(); i++) {
            // Choose the current character
            // Form the remaining string after removing the chosen character
            // Recur with the remaining string and the current character added to the permutation
            findPermutations((str.substring(0, i) + str.substring(i + 1)), ans + str.charAt(i));
        }
    }
}
