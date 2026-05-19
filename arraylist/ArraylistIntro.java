package arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class ArraylistIntro {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        //Time complexity O(1)
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        arr.add(0,5);

        //Time Complexity O(1)
        Integer ele = arr.get(0);
        System.out.println(ele);

        //Time Complexity O(n)
        arr.remove(0);

        //Time Complexity O(n)
        arr.set(1,4);

        //Time complexity O(n)
        //returns boolean
        arr.contains(4);

        //Sorting in ArrayList
        Collections.sort(arr);
        System.out.println(arr);

        Collections.sort(arr , Collections.reverseOrder());
        System.out.println(arr);

        //Multidimensional ArrayList
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            temp.add(2);
            list.add(temp);
    
            temp = new ArrayList<>();
            temp.add(3);
            temp.add(4);
            temp.add(5);
            temp.remove(1);
            list.add(temp);

        for(ArrayList<Integer> l : list){
            for(Integer i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
