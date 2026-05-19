package arraylist;

import java.util.ArrayList;
import java.util.HashMap;

public class Questions {
    //Question 1 : You are given an integer arraylist nums. A number x is lonely when it appears only once, and no adjacent numbers (i.e. x + 1 and x - 1) appear in the arraylist.

    static void lonelyNumbers(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            //merge(Integer key, Integer value, BiFunction remappingFunction)
            //If the key exists in the map, then the remapping function is called with the existing value and the new value, and the result is stored as the new value for that key. If the key does not exist, then the new value is simply added to the map.
            //Integer::sum is lamda expression for (a, b) -> a + b, which takes two integers and returns their sum. In this context, it is used as the remapping function for 
            // Integer.sum(oldValue, 1)
            map.merge(num, 1, Integer::sum);
        }
        ArrayList<Integer> lonelyNumbers = new ArrayList<>();
        for(var e : map.entrySet()) {
            int num = e.getKey();
            int count = e.getValue();
            if(count == 1 && !map.containsKey(num - 1) && !map.containsKey(num + 1)) {
                lonelyNumbers.add(num);
            }
        }
        System.out.println(lonelyNumbers);
    }
    //In an arraylist find the number with maximum instance following a key provided by the user. fox example [1,100,200,1,100] with key=1 answer is 100 because it is the number with maximum instance following 1 in the arraylist.
    static void mostFrequentFollowingKey(ArrayList<Integer> list, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max=0;
        int result = 0;
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) == key) {
                int nextNum = list.get(i + 1);
                map.merge(nextNum, 1, Integer::sum);
                if(map.get(nextNum)>max){
                    max = map.get(nextNum);
                    result = nextNum;
                }
            }
        }
        System.out.println(result);
    }
    //Beautiful ArrayList : Given an integer n, return a list of the first n numbers in the beautiful array. A beautiful array is an array that is a permutation of the integers from 1 to n such that for every i < k < j , 2*nums[k] != nums[i] + nums[j]. like [1,5,3] is a beautiful array but [1,3,5] is not because 2*3 = 1 + 5. and between even and odd between them should be (even+odd)/2 = odd/2 which is not an integer.
    static void beautifulArray(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        while(result.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int e : result){
                if(e*2-1 <= n) {
                    temp.add(e*2-1);
                }
            }

            for (int e : result){
                if(e*2 <= n) {
                    temp.add(e*2);
                }
            }
            result = temp;
        }
        System.out.println(result);
    }


    public static void main(String[] args) {
        int[] nums = {10, 6, 5, 8};
        lonelyNumbers(nums);

        int[] nums2 = {1, 100, 200, 1, 100};
        ArrayList<Integer> list = new ArrayList<>();
        for(int n : nums2) {
            list.add(n);
        }
        mostFrequentFollowingKey(list, 1);

        beautifulArray(5);
    }
}
