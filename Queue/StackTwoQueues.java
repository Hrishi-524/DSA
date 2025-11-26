package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackTwoQueues {
    public class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void add(int value) {
            if(!q1.isEmpty()) 
                q1.add(value);
            else 
                q2.add(value);
        }

        public static int remove() {
            if(isEmpty()) return Integer.MIN_VALUE;
            int top = -1;
            if(!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if(q1.isEmpty()) break;
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty()) break;
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek() {
            if(isEmpty()) return Integer.MIN_VALUE;
            return !q1.isEmpty() ? q1.peek() : q2.peek();
        }
    }
    public static void main(String[] args) {
        
    }
}
