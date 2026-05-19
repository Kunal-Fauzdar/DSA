package Heap;

import java.util.PriorityQueue;

public class WeakestSoldier {

    public static class Soldier implements Comparable<Soldier>{
        int id;
        int power;
        Soldier(int id , int power){
            this.id = id;
            this.power = power;
        }
        @Override
        public int compareTo(Soldier s2){
            if(this.power == s2.power){
                return this.id - s2.id;
            }
            return this.power - s2.power;
        }
    }
    public static void main(String[] args) {
        
        int[][] soldiers = {{1,1,1,0}, {1, 1, 0, 0}, {1, 1, 0, 0}, {1, 1, 1, 0}};
        int k = 2;
        PriorityQueue<Soldier> pq = new PriorityQueue<>();
        for(int i=0 ; i<soldiers.length ; i++){
            int count = 0;
            for(int j=0 ; j<soldiers[i].length ; j++){
                if(soldiers[i][j] == 1){
                    count++;
                }
            }
            pq.add(new Soldier(i, count));
        }
        for(int i=0 ; i<k ; i++){
            System.out.println(pq.remove().id);
        }
    }
}
