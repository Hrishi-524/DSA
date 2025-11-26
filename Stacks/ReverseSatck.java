package Stacks;

import java.util.Stack;

public class ReverseSatck {
    public static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reverse(stack);
        PushBottom.pushAtBottom(stack, top);
    }
    
    public static void main(String[] args) {
        
    }
}
