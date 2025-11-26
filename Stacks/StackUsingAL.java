package Stacks;

import java.util.ArrayList;

public class StackUsingAL {

    public static class Stack {
        static ArrayList<Integer> stack = new ArrayList<>();

        public boolean isEmpty() {
            return stack.size() == 0;
        }

        //push 
        public void push(int data) {
            stack.add(data);
        }

        //pop 
        public int pop() {
            if(isEmpty()) return Integer.MIN_VALUE;
            int top = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            return top;
        }

        //peek
        public int peek() {
            return stack.get(stack.size()-1);
        }

        //print
        public void print() {
            System.out.println("Following is the stack state:");
            for(int num : stack) {
                System.out.println(num);
            }
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        Stack stk = new Stack();
        stk.push(10);
        stk.print();
        stk.push(20);
        stk.print();
        stk.push(30);
        stk.print();
        stk.pop();
        stk.print();
    }
}
