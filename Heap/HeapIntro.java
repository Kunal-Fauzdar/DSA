package Heap;

import java.util.ArrayList;

public class HeapIntro {
    public static class Heap {
        static ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int child = arr.size()-1;
            int parent = (child-1)/2;

            while(arr.get(child) < arr.get(parent)){
                int temp = arr.get(child);
                arr.set(child,arr.get(parent));
                arr.set(parent , temp);
                child = parent;
                parent = (child-1)/2;
            }
        }
        public void seek(){
            System.out.println(arr.get(0));
        }

        public void heapify(int index){
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

        public int remove(){
            int removedElement = arr.get(0);

            arr.set(0 , arr.get(arr.size()-1));
            arr.set(arr.size()-1 , removedElement);

            arr.remove(arr.size()-1);

            heapify(0);

            return removedElement;
        } 
    }

    
    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(2);
        pq.add(4);
        pq.add(5);
        pq.add(6);
        pq.add(7);
        pq.add(1);
        while (Heap.arr.size() > 0){
            pq.seek();
            pq.remove();
        }
        System.out.println();
    }   
}
