package Stacks;

import java.util.Stack;

public class PushBottom {

    public static void pushAtBottom(Stack<Integer> stack, int item) {
        if(stack.isEmpty()) {
            stack.push(item);
            return;
        }

        int top = stack.pop();
        pushAtBottom(stack, item);
        stack.push(top);
    }

    public static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reverse(stack);
        pushAtBottom(stack, top);
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println(stack);

        pushAtBottom(stack, 4);

        System.out.println(stack);

        reverse(stack);

        System.out.println(stack);
    }
}
