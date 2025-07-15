import java.util.Hashtable;
import java.util.LinkedList;

public class wordSearch {
    public static void main(String[] args) {
        char[][] words = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String target = "ABCCED";
        searchWord(words, target);
    }
    public static void searchWord(char[][] words,String target){
        int index = 0; // Index to track position in target string
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}}; // Directions for right, down, left, up  
        Hashtable<Character, LinkedList<String>> ht = new Hashtable<>(); // Starting position in the 2D array     
        // Iterate through each character in the 2D array
        
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[0].length;j++){
                
                if(words[i][j] == target.charAt(0)){
                   if(!ht.containsKey(target.charAt(0))){
                       ht.put(target.charAt(0), new LinkedList<>());
                   }
                   ht.get(target.charAt(0)).add(i + "-" + j);
                }
            }
        }
        System.out.println(ht);
        int condition = 0; // Condition to check if the word is found
        while()
    }
}
