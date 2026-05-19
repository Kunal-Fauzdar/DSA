package arraylist;

import java.util.ArrayList;

public class MostWaterContainer {
    public static void mostWaterContainer(ArrayList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        int maxArea = 0;
        while(left < right) {
            int height = Math.min(list.get(left), list.get(right));
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
            if(list.get(left) < list.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(maxArea);
    }  
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        mostWaterContainer(list);
    }
}
