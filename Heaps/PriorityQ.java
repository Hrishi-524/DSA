package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQ {

    static class Student implements Comparable<Student> {
        String name;
        int rank;
 
        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        //overriding function that exists in Comparable interface 
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
        
    }
    public static void main(String[] args) {
        /** BASICS AND ORDERING */
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(4); //O(log n)
        pq.add(1);
        pq.add(5);
        pq.add(7);
        pq.add(0);

        while (!pq.isEmpty()) {
            System.out.print(pq.peek()+" ");
            pq.remove(); // O(log n)
        }

        /**
         *  OUTPUT :-
         *  0 1 4 5 7
         */

        System.out.println();

        // Like we used Compartor.reverseOrder() in Arrays.sort we can reverse the logic of pq
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Comparator.reverseOrder());
        rpq.add(4); //O(log n)
        rpq.add(1);
        rpq.add(5);
        rpq.add(7);
        rpq.add(0);

        while (!rpq.isEmpty()) {
            System.out.print(rpq.peek()+" ");
            rpq.remove(); // O(log n)
        }

        /**
         *  OUTPUT :-
         *  7 5 4 1 0 
         */

        /** CLASS STUDENT PQ */
        System.out.println();
        System.out.println("----Student Object Custom thing");
        PriorityQueue<Student> spq = new PriorityQueue<>();

        spq.add(new Student("A", 12));
        spq.add(new Student("B", 5));
        spq.add(new Student("C", 2));
        spq.add(new Student("D", 10));
        spq.add(new Student("E", 17));

        while (!spq.isEmpty()) {
            System.out.println(spq.peek().name+"->"+spq.peek().rank);
            spq.remove(); // O(log n)
        }

        /*
            OUTPUT:-
            C->2
            B->5
            D->10
            A->12
            E->17
        */
    }   
}
