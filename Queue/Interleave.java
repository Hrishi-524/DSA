package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Interleave {

    public static Queue<Integer> interleaveQueue(Queue<Integer> q) {
        if(q.size() % 2 == 1) {
            System.err.println("Queue must be even to interleave");
            return q;
        }
        int initSize = q.size();//O(n)
        Queue<Integer> h = new LinkedList<>();// helper queue

        while (q.size() != initSize/2) {//O(n/2)
            h.add(q.remove());
        }

        while (!q.isEmpty() && !h.isEmpty()) {//O(n)
            q.add(h.remove());
            q.add(q.remove());
        }

        System.err.println("Interleaved Queue :" + q);
        return q;
    }
    public static void main(String[] args) {
        
    }
}
