package Queue;

public class QueueArray {

    public class Queue {
        static int[] queue;
        static int front;
        static int rear;

        Queue(int n) {
            queue = new int[n];
            front = rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public void add(int data) {
            if(rear == queue.length-1) {
                System.out.println("queue is full");
                return;
            }
            if(isEmpty()) {
                front = 0;
            }
            rear = rear + 1;
            queue[rear] = data;
        }

        public int remove() {
            if(isEmpty()) {
                System.out.println("queue is empty");
                return Integer.MIN_VALUE;
            }
            /**
             * front = front + 1;
             * this is front upadtion approach
             */
            int removed = queue[0];
            for(int i=1; i<queue.length; i++) {
                queue[i-1] = queue[i];
            }
            rear = rear-1;
            return removed;
        }
    }
    public static void main(String[] args) {
        
    }
}
