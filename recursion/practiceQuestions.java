package recursion;

public class practiceQuestions {
    public static void main(String[] args) {
        printIndices(new int[]{3, 2, 4, 5, 6, 2, 7}, 0, 2);
        convertIntToString(11052005, new StringBuilder(""));
        findSubstringStartingEndingSame("abcab", 0, 0);
        towerOfHanoi(3, "A", "B", "C");
    }

    static void printIndices(int arr[], int i, int key) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == key) {
            System.out.println(i);
        }
        printIndices(arr, i + 1, key);
    }

    static void convertIntToString(int n, StringBuilder str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        int digit = n % 10;
        switch(digit){
            case 0:
                str.insert(0, "zero ");
                break;
            case 1:
                str.insert(0, "one ");
                break;
            case 2:
                str.insert(0, "two ");
                break;
            case 3:
                str.insert(0, "three ");
                break;
            case 4:
                str.insert(0, "four ");
                break;
            case 5:
                str.insert(0, "five ");
                break;
            case 6:
                str.insert(0, "six ");
                break;
            case 7:
                str.insert(0, "seven ");
                break;
            case 8:
                str.insert(0, "eight ");
                break;
            case 9:
                str.insert(0, "nine ");
                break;
        }
        convertIntToString(n / 10, str);
    }

    static void findSubstringStartingEndingSame(String str, int i, int count) {
        if (i == str.length()) {
            System.out.println(count);
            return;
        }
        for (int j = i; j < str.length(); j++) {
            if (str.charAt(i) == str.charAt(j)) {
                count++;
            }
        }
        findSubstringStartingEndingSame(str, i + 1, count);
    }


    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        // transfer top n-1 from src to helper using dest as 'helper'
        towerOfHanoi(n - 1, src, dest, helper);
        // transfer nth from src to dest
        System.out.println("transfer disk " + n + " from " + src + " to " + dest);
        // transfer n-1 from helper to dest using src as 'helper'
        towerOfHanoi(n - 1, helper, src, dest);
    }
}
