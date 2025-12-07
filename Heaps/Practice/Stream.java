package Heaps.Practice;

import java.util.PriorityQueue;

public class Stream {
    public static int kthLargestInStream(int[] stream, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : stream) {
            pq.add(val);
        }

        for(int i=0; i<k; i++) {                        
            pq.remove();
        }

        return pq.peek();
    }
    public static void main(String[] args) {
        
    }
}  