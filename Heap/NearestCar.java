package Heap;

import java.util.PriorityQueue;

public class NearestCar {

    public static class Car implements Comparable<Car>{
        int x;
        int y;
        int distsqr;
        Car(int x , int y){
            this.x = x;
            this.y = y;
            this.distsqr = x*x + y*y;
        }
        @Override
        public int compareTo(Car c2){
            return this.distsqr - c2.distsqr;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Car> pq = new PriorityQueue<>();
        pq.add(new Car(1, 2));
        pq.add(new Car(3, 4));
        pq.add(new Car(5, 6));

        int k = 2;
        for(int i=0 ; i<k ; i++){
            Car c = pq.remove();
            System.out.println("Car at ("+c.x+","+c.y+") with distance "+Math.sqrt(c.distsqr));
        }
    }
}
