package arraylist;
import java.util.ArrayList;


//Here the array is sorted and then rotated. We have to find if there is a pair with given sum in the array or not.
public class PairSum2 {

    static boolean pairSum(ArrayList<Integer> list, int target) {
        int breakingPoint = 0;
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) > list.get(i + 1)) {
                breakingPoint = i;
                break;
            }
        }
        int left = breakingPoint + 1;
        int right = breakingPoint;
        while(left != right) {
            int sum = list.get(left) + list.get(right);
            if(sum == target) {
                return true;
            } else if(sum < target) {
                left = (left + 1) % list.size();
            } else {
                right = (right - 1 + list.size()) % list.size();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(7);
        int target = 14;
        System.out.println(pairSum(list, target));
    }
}
