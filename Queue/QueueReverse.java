package Queue;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class QueueReverse {

    public static Queue<Integer> reverse(Queue<Integer> q) {
        if(q.isEmpty()) {
            System.out.println("Empty queue cannot be reversed");
            return q;
        }
        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        return q;
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<=9; i++) {
            q.add(i);
        }

        System.out.println(reverse(q));;
    }
}
