package Heap;

import java.util.ArrayList;

public class KthLargest {

    public static ArrayList<Integer> arr = new ArrayList<>();
    
    public static void add(int data){
        arr.add(data);
        int child = arr.size()-1;
        int parent = (child-1)/2;

        while(arr.get(child)<arr.get(parent)){
            int temp = arr.get(child);
            arr.set(child , arr.get(parent));
            arr.set(parent,temp);
            child = parent;
            parent = (child-1)/2;
        }
    }

    public static void heapify(int index){
        int left = 2*index + 1;
        int right = 2*index + 2;
        int minIdx = index;

        if(left < arr.size() && arr.get(left)<arr.get(minIdx)){
            minIdx = left;
        }   

        if(right < arr.size() && arr.get(right)<arr.get(minIdx)){
            minIdx = right;
        }
        if(minIdx != index){
            int temp = arr.get(index);
            arr.set(index , arr.get(minIdx));
            arr.set(minIdx , temp);
            heapify(minIdx);
        }
    }

    public static int remove(){
            int removedElement = arr.get(0);

            arr.set(0 , arr.get(arr.size()-1));
            arr.set(arr.size()-1 , removedElement);

            arr.remove(arr.size()-1);

            heapify(0);

            return removedElement;
        } 

    public static ArrayList<Integer> Kthlargest(int[] in , int k){
        ArrayList<Integer> out = new ArrayList<>();
        for(int i=0 ; i<in.length-1 ; i++){
            add(in[i]);
            if(arr.size()<k){
                out.add(-1);
            }
            else if(arr.size()>k){
                remove();
                heapify(0);
            }
            if(arr.size()>=k){
                out.add(arr.get(0));
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] in = {10, 20, 11, 70, 50, 40, 100, 5};
        ArrayList<Integer> out =  Kthlargest(in, 3);
        for (Integer integer : out) {
            System.out.print(integer+" ");
        }
        System.out.println();
    }
}
