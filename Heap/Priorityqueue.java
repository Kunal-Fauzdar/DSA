package Heap;
import java.util.Comparator;
import java.util.PriorityQueue;
class PriorityQueueExample{

    public static class Student implements Comparable<Student>{
        String name ;
        int rollNo ;
        Student(String name , int rollNo){
            this.name = name ;
            this.rollNo = rollNo ;
        }
        @Override
        public int compareTo(Student s2){
            return this.rollNo - s2.rollNo ;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(2);
        pq.add(8);
        pq.add(1);
        while(pq.isEmpty() == false){
            System.out.println(pq.peek());
            pq.remove();
        }

        PriorityQueue<Student> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.add(new Student("Alice", 10));
        pq2.add(new Student("Bob", 5));
        pq2.add(new Student("Charlie", 15));
        while(pq2.isEmpty() == false){
            Student s = pq2.peek();
            System.out.println(s.name + "-" + s.rollNo);
            pq2.remove();
        }
    }
}