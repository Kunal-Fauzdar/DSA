package Heap;

import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ropes = {4, 3, 2, 6};
        for(int rope : ropes){
            pq.add(rope);
        }
        int cost = 0;
        while(pq.size()>1){
            int first = pq.remove();
            int second = pq.remove();
            cost += first + second;
            pq.add(first+second);
        }
        System.out.println(cost);
    }
}
