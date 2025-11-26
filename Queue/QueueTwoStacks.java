package Queue;

import java.util.Stack;

public class QueueTwoStacks {
    public class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int value) {
            // s1 -> s2
            while (!isEmpty()) {
                int temp = s1.pop();
                s2.push(temp);
            }

            // value -> s1
            s1.push(value);

            // s2 -> s1
            while (!s2.isEmpty()) {
                int temp = s2.pop();
                s1.push(temp);
            }
        }

        public static int remove() {
            if(isEmpty()) return Integer.MIN_VALUE;
            return s1.pop();
        }

        public static int peek() {
            if(isEmpty()) return Integer.MIN_VALUE;
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        
    }
}
