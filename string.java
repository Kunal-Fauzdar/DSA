public class string {
    public static void main(String[] args) {
        String name="Kunal";
        //String are immutable , hence cannot be changed 
        System.out.println(name.length());
        for(int i=0;i<name.length();i++){
            System.out.print(name.charAt(i)+" ");
        }
        System.out.println();
        //checking palindrome
        String palin = "noon";
        int flag=0;
        for(int i=0;i<(int)(palin.length()/2);i++){
            if(palin.charAt(i)!=palin.charAt(palin.length()-i-1))
            {
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.println("string is palindrome");
        }else System.out.println("string is not Plaindrome");

        //compare strings 
        String s1 = "tony";
        String s2 = "tony";         //both point to same string object
        String s3 = new String("tony"); //creates a new object containing same string
        if(s1==s2) System.out.println("equal");         //equal
        if(s1!=s3) System.out.println("not equal");     //not equal
        if(s1.equals(s3)) System.out.println("equal"); //equal

        //substring
        System.out.println("HelloWorld".substring(0,5));    //Hello

        //printing largest string lexiographically
        String[] arr={"apple","mango","banana"};
        System.out.println(largestString(arr));

        //StringBuilder 
        //We use StringBuilder when we need to make a lot of changes in string 
        //without stringbuilder , everttime a new string will be created with copying previous string content for this code str+="newstr" 
        StringBuilder str = new StringBuilder("");
        for(char i='a';i<='z';i++){
            str.append(i);
        }
        System.out.println(str.toString()); //toString() to convert ab Object to string(for ex Integer x=new Integer())

        //to capitalize a string
        String capstr="   there is only one good knowledge";
        System.out.println(getUppercase(capstr));

        //compressed string
        String repeated = "aaabccd";
        System.out.println(compressString(repeated));

    }
    public static String largestString(String[] arr){
        String largest = arr[0];
        for(int i=0;i<arr.length;i++){
            if(largest.compareTo(arr[i])<0){
                largest=arr[i];
            }
        }
        return largest;
    }
    public static String getUppercase(String str){
        StringBuilder uppercaseString = new StringBuilder("");
        int i=0;
        while(str.charAt(i)==' '){
            uppercaseString.append(str.charAt(i));
            i++;
        }
        uppercaseString.append(Character.toUpperCase(str.charAt(i)));
        i++;
        while(i<str.length()){
            if(str.charAt(i)==' '){
                uppercaseString.append(str.charAt(i));
                i++;
                uppercaseString.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                uppercaseString.append(str.charAt(i));
            }
            i++;
        }
        return uppercaseString.toString();
    }
    public static String compressString(String str){
        StringBuilder compressedString = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                i++;
                count++;
            }
            compressedString.append(str.charAt(i));
            if(count>1){
                compressedString.append(count.toString());
            }
        }
        return compressedString.toString();
    }
}
