package Stacks;

import java.util.LinkedList;

public class StackUsingLL {
    public static class Stack {
        static LinkedList<Integer> stack = new LinkedList<>();    

        public static boolean isEmpty() {
            return stack.isEmpty();
        }

        //push 
        public static void push(int data) {
            stack.addFirst(data);
        }

        //pop
        public static int pop() {
            if(isEmpty()) return Integer.MIN_VALUE;
            int top = (int) stack.getFirst();
            stack.removeFirst();
            return top;
        }

        //peek 
        public static int peek() {
            return (int) stack.getFirst();
        }
    }
    public static void main(String[] args) {
        
    }
}