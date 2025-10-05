package recursion;

public class removeDuplicate {
    public static void main(String[] args) {
        String str = "aabbccddeeff";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }

    public static void removeDuplicates(String str , int index , StringBuilder newstr , boolean[] characters) {
        if (str.length() == 0) {
            System.out.println("String is empty");
            return ;
        }
        if(index == str.length()){
            System.out.println(newstr);
            
            return ;
        }
        if(characters[str.charAt(index)-'a'] == true){
            removeDuplicates(str, index+1, newstr, characters);
        }
        else{
            characters[str.charAt(index)-'a'] = true;
            removeDuplicates(str, index+1, newstr.append(str.charAt(index)), characters);
        }
        
        
    }
}
